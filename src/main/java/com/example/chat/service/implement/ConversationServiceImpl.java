package com.example.chat.service.implement;

import com.example.chat.model.Conversation;
import com.example.chat.model.User;
import com.example.chat.repository.ConversationRepository;
import com.example.chat.repository.UserRepository;
import com.example.chat.service.ConversationService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConversationServiceImpl implements ConversationService {

  private final UserRepository userRepository;
  private final ConversationRepository conversationRepository;

  @Override
  public Optional<Conversation> findConversationByUsers(int user1Id, int user2Id) {
    Optional<User> user1 = userRepository.findById(user1Id);
    Optional<User> user2 = userRepository.findById(user2Id);
    if (user1.isEmpty() || user2.isEmpty()) {
      return Optional.empty();
    }
    Optional<Conversation> existingConversation = conversationRepository.findConversationByUsers(
        user1.get(), user2.get());
    if (existingConversation.isEmpty()) {
      return Optional.empty();
    }
    return existingConversation;
  }

  @Override
  public Conversation createConversation(User user1, User user2) {
    Conversation newConversation = new Conversation();
    newConversation.setUser1(user1);
    newConversation.setUser2(user2);

    return conversationRepository.save(newConversation);
  }
}
