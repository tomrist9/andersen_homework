package org.example.dao;


import org.example.entity.User;

public interface UserDao {
    void saveUser(User user);

    User getUserById(Long id);

    void deleteUserAndTicketsById(int userId);
}
