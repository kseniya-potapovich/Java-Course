package repository;

import models.Goal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoalCRUD {
    private Connection connection;
    private final static String SELECT_ALL_FROM_GOALS = "SELECT * FROM goals";
    private final static String CREATE_GOAL = "INSERT INTO goals(id, user_id, type, description, date_start, date_finish)"
            + "VALUES(DEFAULT,?,?,?,?,?)";
    private final static String GET_GOAL_BY_ID = "SELECT * FROM goals WHERE id = ?";
    private final static String UPDATE_GOAL = "UPDATE goals SET user_id = ?, type = ?, description = ?, date_start = ?, date_finish = ? WHERE id = ?";
    private final static String DELETE_GOAL = "DELETE FROM goals WHERE id = ?";

    public GoalCRUD() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/webApp", "postgres", "root");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public List<Goal> getAll() {
        List<Goal> goals = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_GOALS);
            while (resultSet.next()) {
                Goal goal = purseGoal(resultSet);
                if (goal.getId() != null) {
                    goals.add(goal);
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return goals;
    }

    public boolean addGoal(Goal goal) {
        try {
            PreparedStatement statement = connection.prepareStatement(CREATE_GOAL);
            statement.setLong(1, goal.getUserId());
            statement.setString(2, goal.getType());
            statement.setString(3, goal.getDescription());
            statement.setTimestamp(4, goal.getDateStart());
            statement.setTimestamp(5, goal.getDateFinish());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public Goal getGoalById(Long id) {
        Goal goal = new Goal();
        try {
            PreparedStatement statement = connection.prepareStatement(GET_GOAL_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                goal = purseGoal(resultSet);
                if (goal.getId() != null) {
                    return goal;
                }
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return goal;
    }

    public boolean updateGoal(Goal goal) {
        try {
            PreparedStatement statement = connection.prepareStatement(UPDATE_GOAL);
            statement.setLong(1, goal.getUserId());
            statement.setString(2, goal.getType());
            statement.setString(3, goal.getDescription());
            statement.setTimestamp(4, goal.getDateStart());
            statement.setTimestamp(5, goal.getDateFinish());
            statement.setLong(6, goal.getId());
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean deleteGoal(Long id) {
        try {
            PreparedStatement statement = connection.prepareStatement(DELETE_GOAL);
            statement.setLong(1, id);
            return statement.executeUpdate() == 1;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    private Goal purseGoal(ResultSet resultSet) {
        Goal goal = new Goal();
        try {
            goal.setId(resultSet.getLong("id"));
            goal.setUserId(resultSet.getLong("user_id"));
            goal.setType(resultSet.getString("type"));
            goal.setDescription(resultSet.getString("description"));
            goal.setDateStart(resultSet.getTimestamp("date_start"));
            goal.setDateFinish(resultSet.getTimestamp("date_finish"));
        } catch (SQLException e) {
            System.out.println(e);
        }
        return goal;
    }
}
