package com.example.ticket.service;

import com.example.ticket.entity.User;
import com.example.ticket.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    // TODO: Implement user service methods
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUserAndTicketsById(Long userId) {
        if (userRepository.existsById(userId)) {
            userRepository.deleteUserAndTicketsById(userId);
        } else {
            throw new RuntimeException("User not fouund with id:" + userId);
        }

    }

}
