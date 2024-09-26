package com.example.chat.service.implement;

import com.example.chat.model.Conversation;
import com.example.chat.model.Status;
import com.example.chat.model.User;
import com.example.chat.repository.ConversationRepository;
import com.example.chat.repository.UserRepository;
import com.example.chat.service.UserService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;


  @Override
  public void saveUser(User user) {
    user.setStatus(Status.ONLINE);
    userRepository.save(user);
  }

  public void disconnect(User user) {
    var storedUser = userRepository.findById(user.getUserId()).orElse(null);
    if(storedUser != null) {
      storedUser.setStatus(Status.OFFLINE);
      userRepository.save(storedUser);
    }
  }

  @Override
  public List<User> findAllConnectedUsers() {
    return userRepository.findAllByStatus(Status.ONLINE);
  }

  @Override
  public User findUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public User findUserByPhone(String phone) {
    return userRepository.findByPhone(phone);
  }

  @Override
  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public List<User> findAllUsersExceptThisUserId(int userId) {
    return userRepository.findAllUsersExceptThisUserId(userId);
  }

}
