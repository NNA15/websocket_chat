package com.example.chat.repository;

import com.example.chat.model.Conversation;
import com.example.chat.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ConversationRepository extends JpaRepository<Conversation, Integer> {

  @Query(nativeQuery = true, value = "SELECT * FROM conversation c WHERE (c.user1 = :user1 AND c.user2 = :user2) OR (c.user1 = :user2 AND c.user2 = :user1)")
  Optional<Conversation> findConversationByUsers(@Param("user1") User user1,
      @Param("user2") User user2);
}
