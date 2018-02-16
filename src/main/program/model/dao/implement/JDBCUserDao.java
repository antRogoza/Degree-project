package model.dao.implement;

import model.User;
import model.dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JDBCUserDao implements UserDao {
    private static final String CREATE = "INSERT INTO  user(ID_USER,FIRSTNAME,LASTNAME,ID_AUTHORIZATION)"
            + " VALUES (?, ?, ?, ?)";
    private static final String FIND_BY_ID = "SELECT * FROM user WHERE ID_USER = ?";
    private static final String QUERY_FIND_ALL = "SELECT * FROM user";
    private static final String QUERY_UPDATE = "UPDATE user SET FIRSTNAME = ?, LASTNAME = ?," +
            " ID_AUTHORIZATION = ?";
    private static final String DELETE = "DELETE FROM client WHERE ID_CLIENT = ?";

    private Connection connection;

    public JDBCUserDao(Connection c) {
        this.connection = c;
    }

    private void forCreateAndUpdate(User user, String QUERY){
        try (PreparedStatement ps = connection.prepareStatement
                (QUERY)) {
            ps.setString(1, String.valueOf(user.getIdUser()));
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, String.valueOf(user.getIdLogin()));

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void create(User user) {
        forCreateAndUpdate(user,CREATE);
    }

    @Override
    public User findById(int id) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement
                (FIND_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return extractFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private User extractFromResultSet(ResultSet rs)
            throws SQLException {
        User result = User.newBuilder()
                .setId(rs.getInt("ID_USER"))
                .setFirstName(rs.getString("FIRSTNAME"))
                .setLastName(rs.getString("LASTNAME"))
                .setIdAuthorization(rs.getInt("ID_AUTHORIZATION"))
                .build();
        return result;
    }

    @Override
    public List<User> findAll() {
        ArrayList<User> resultList = new ArrayList<>();
        try (Statement ps = connection.createStatement()) {
            ResultSet rs = ps.executeQuery(QUERY_FIND_ALL);
            while (rs.next()) {
                User result = extractFromResultSet(rs);
                resultList.add(result);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultList;
    }

    @Override
    public void update(User user) {
        forCreateAndUpdate(user,QUERY_UPDATE);
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement(
                DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(User user) {
        try (PreparedStatement ps = connection.prepareStatement(
                DELETE)) {
            ps.setInt(1, user.getIdUser());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() throws Exception {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

