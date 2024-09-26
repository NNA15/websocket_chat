package com.example.chat.repository;

import com.example.chat.model.Conversation;
import com.example.chat.model.Message;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<Message, Integer> {

  List<Message> findAllByConversation(Conversation conversation);

  void deleteAllByConversation(Conversation conversation);

}
