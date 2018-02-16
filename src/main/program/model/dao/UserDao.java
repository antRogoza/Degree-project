package model.dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void create(User user);
    User findById(int id) throws SQLException;
    List<User> findAll();
    void update(User user);
    void delete(int id);
    void delete(User user);
    void close() throws Exception;
}
