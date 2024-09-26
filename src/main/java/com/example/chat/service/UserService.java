package com.example.chat.service;

import com.example.chat.model.Conversation;
import com.example.chat.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

  void saveUser(User user);

  User findUserByEmail(String email);

  User findUserByPhone(String phone);

  List<User> findAllUsers();

  List<User> findAllUsersExceptThisUserId(int userId);

  void disconnect(User user);

  List<User> findAllConnectedUsers();
}
