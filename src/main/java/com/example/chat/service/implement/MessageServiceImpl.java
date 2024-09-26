package com.example.chat.service.implement;

import com.example.chat.model.Conversation;
import com.example.chat.model.Message;
import com.example.chat.repository.ConversationRepository;
import com.example.chat.repository.MessageRepository;
import com.example.chat.repository.UserRepository;
import com.example.chat.service.ConversationService;
import com.example.chat.service.MessageService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MessageServiceImpl implements MessageService {

  private final SimpMessagingTemplate messagingTemplate;
  private final UserRepository userRepository;
  private final ConversationRepository conversationRepository;
  private final MessageRepository messageRepository;
  private final ConversationServiceImpl conversationService;

  @Override
  public void sendMessage(Message message) {
    if (message.getConversation() == null) {
      Conversation conversation = conversationRepository.findConversationByUsers(
          message.getSender(), message.getReceiver()).orElseGet(
          () -> conversationService.createConversation(message.getSender(), message.getReceiver()));
    }
    messagingTemplate.convertAndSendToUser(String.valueOf(message.getReceiver().getUserId()), "queue/messages", message);
    messageRepository.save(message);
  }

  @Override
  public Message saveMessage(Message message) {
    return messageRepository.save(message);
  }
}
