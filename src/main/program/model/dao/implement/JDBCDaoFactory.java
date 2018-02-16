package model.dao.implement;

import model.dao.DaoFactory;
import model.dao.UserDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/aurea_mediocritas",
                    "root",
                    "antRogoza97");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
