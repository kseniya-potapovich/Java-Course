package crud;

import models.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class UserCRUD {
    private Connection connection = null;
    private final static String SELECT_ALL = "SELECT * FROM users";
    private final static String SELECT_USER_FROM_USERS = "SELECT * FROM users WHERE id = ?";
    private final static String CREATE_USER = "INSERT INTO users(id, first_name, last_name, email, age, gender)" +
            "VALUES(DEFAULT,?,?,?,?,?)";
    private final static String UPDATE_USER = "UPDATE users SET first_name = ?, last_name = ?, email = ?, age = ?, gender = ? WHERE id = ?";
    private final static String DELETE_USER = "DELETE FROM users WHERE id = ?";

    public UserCRUD() throws RuntimeException {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webApp", "postgres", "root");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SELECT_ALL);
            while (result.next()) {
                User user = parseUser(result);
                if (user.getId() != null) {
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return users;
    }

    public User getById(Long id) {
        User user = new User();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_USER_FROM_USERS);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                user = parseUser(result);
                if (user.getId() != null) {
                    return user;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }

    public boolean updateUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_USER);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getAge());
            statement.setString(5, user.getGender());
            statement.setLong(6, user.getId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean addUser(User user) {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE_USER);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getEmail());
            statement.setInt(4, user.getAge());
            statement.setString(5, user.getGender());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteUser(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_USER);
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    private User parseUser(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getLong("id"));
            user.setFirstName(resultSet.getString("first_name"));
            user.setLastName(resultSet.getString("last_name"));
            user.setEmail(resultSet.getString("email"));
            user.setAge(resultSet.getInt("age"));
            user.setGender(resultSet.getString("gender"));
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }
}
