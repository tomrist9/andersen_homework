package org.example.dao.impl;

import org.example.config.DatabaseConnection;
import org.example.dao.UserDao;
import org.example.mapper.UserMapper;
import org.example.model.User;

import java.sql.*;

public class UserDaoImpl implements UserDao {


    @Override
    public void saveUser(User user) {
        String query = "INSERT INTO \"User\" (name, creation_date) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, user.getName());
            statement.setDate(2, java.sql.Date.valueOf(user.getCreatedAt())); // Convert LocalDate to SQL Date
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        @Override
        public User getUserById(int id) {
            String query = "SELECT * FROM Users WHERE id = ?";
            try (Connection connection = DatabaseConnection.getConnection();
                 PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return UserMapper.mapToUser(resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }

    @Override
    public void deleteUserAndTicketsById(int userId) {
        String deleteTicketsQuery = "DELETE FROM ticket WHERE user_id = ?";
        String deleteUserQuery = "DELETE FROM \"User\" WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection()) {
            connection.setAutoCommit(false);
            Savepoint savepoint = connection.setSavepoint("BeforeDelete");

            try (PreparedStatement deleteTicketsStmt = connection.prepareStatement(deleteTicketsQuery);
                 PreparedStatement deleteUserStmt = connection.prepareStatement(deleteUserQuery)) {
                deleteTicketsStmt.setInt(1, userId);
                deleteTicketsStmt.executeUpdate();

                deleteUserStmt.setInt(1, userId);
                deleteUserStmt.executeUpdate();

                connection.commit();
            } catch (SQLException e) {
                connection.rollback(savepoint);
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}