package repository;

import models.Friendship;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FriendshipCRUD {
    private Connection connection = null;
    private final static String SELECT_ALL = "SELECT * FROM friendship";
    private final static String CREATE_FRIENDSHIP = "INSERT INTO friendship(id, user_id, friend_id)"
            + "VALUES(DEFAULT, user_id = ?, friend_id = ?)";
    private final static String SELECT_FRIENDSHIP = "SELECT * FROM friendship WHERE id = ?";
    private final static String UPDATE_FRIENDSHIP = "UPDATE friendship SET user_id = ?, friend_id = ? WHERE id = ?";
    private final static String DELETE_FRIENDSHIP = "DELETE FROM friendship WHERE id = ?";

    public FriendshipCRUD() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webApp", "postgres", "root");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public List<Friendship> getAll() {
        List<Friendship> friendships = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(SELECT_ALL);
            while (result.next()) {
                Friendship friendship = parseFriendship(result);
                if (friendship.getId() != null) {
                    friendships.add(friendship);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return friendships;
    }

    public boolean addFriendship(Friendship friendship) {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE_FRIENDSHIP);
            statement.setLong(1, friendship.getUserId());
            statement.setLong(2, friendship.getFriendId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Friendship getById(Long id) {
        Friendship friendship = new Friendship();
        try {
            PreparedStatement statement = connection.prepareStatement(SELECT_FRIENDSHIP);
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                friendship = parseFriendship(result);
                if (friendship.getId() != null) {
                    return friendship;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return friendship;
    }

    public boolean updateFriendship(Friendship friendship) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_FRIENDSHIP);
            statement.setLong(1, friendship.getUserId());
            statement.setLong(2, friendship.getFriendId());
            statement.setLong(3, friendship.getId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteFriendship(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_FRIENDSHIP);
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    private Friendship parseFriendship(ResultSet resultSet) {
        Friendship friendship = new Friendship();
        try {
            friendship.setId(resultSet.getLong("id"));
            friendship.setUserId(resultSet.getLong("user_id"));
            friendship.setFriendId(resultSet.getLong("friend_id"));
        } catch (SQLException e) {
            System.out.println(e);
        }
        return friendship;
    }
}
