package com.example.chat.repository;

import com.example.chat.model.Status;
import com.example.chat.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

  User findByEmail(String email);

  User findByPhone(String phone);

  List<User> findAllByStatus(Status status);

  @Query(nativeQuery = true, value = "SELECT * FROM user where user_id != ?1")
  List<User> findAllUsersExceptThisUserId(int userId);

}
