package com.natna.forces.user;

import com.natna.forces.exception.ResourceNotFoundException;
import com.natna.forces.user.User;

import java.util.List;

public interface IUserService {

    // Method to add a new user
    User addUser(User user);

    // Method to update an existing user
    User updateUser(Long userId,User user) throws ResourceNotFoundException;

    User updateUserStatus(Long userId, String status) throws ResourceNotFoundException;

    // Method to delete a user by ID
    void deleteUser(Long userId) throws ResourceNotFoundException;

    // Method to retrieve a single user by ID
    User getUserById(Long userId);

    // Method to retrieve all users
    List<User> getAllUsers();

}
