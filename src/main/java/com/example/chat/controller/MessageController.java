package com.example.chat.controller;

import com.example.chat.model.Message;
import com.example.chat.service.implement.MessageServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

  private final MessageServiceImpl messageService;

  @MessageMapping("/chat")
  public void sendMessage(@Payload Message message) {
    messageService.sendMessage(message);
  }
}
