package org.example.dao;

import org.example.model.User;

public interface UserDao {
    void saveUser(User user);

    User getUserById(int id);

    void deleteUserAndTicketsById(int userId);
}
