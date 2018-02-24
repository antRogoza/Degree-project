import model.User;
import model.dao.implement.JDBCDaoFactory;
import model.dao.implement.JDBCUserDao;
import view.View;

import java.sql.Connection;
import java.util.List;

public class App {
    public static void main(String[] args) {
        View view = new View();
        view.printMessage(View.bundle.getString(View.AUTHORS));

        User user1 = User.newBuilder()
                .setId(1)
                .setFirstName("Anton")
                .setLastName("Rogoza")
                .setIdAuthorization(1)
                .build();
        User user2 = User.newBuilder()
                .setId(2)
                .setFirstName("Oleksandr")
                .setLastName("Marochkanich")
                .setIdAuthorization(2)
                .build();
        JDBCDaoFactory jdbcDaoFactory = new JDBCDaoFactory();
        JDBCUserDao jdbcUserDao = (JDBCUserDao) jdbcDaoFactory.createUserDao();
        jdbcUserDao.delete(user1);
        jdbcUserDao.delete(user2);
        jdbcUserDao.create(user1);
        jdbcUserDao.create(user2);

        List<User> clients = new JDBCDaoFactory().createUserDao().findAll();
        System.out.println(clients);

    }
}
