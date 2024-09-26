package com.example.chat.service;

import com.example.chat.model.Conversation;
import com.example.chat.model.User;
import java.util.Optional;

public interface ConversationService {
  Optional<Conversation> findConversationByUsers(int user1Id, int user2Id);

  Conversation createConversation(User user1, User user2);
}
