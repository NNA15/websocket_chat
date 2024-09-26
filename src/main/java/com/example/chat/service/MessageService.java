package com.example.chat.service;

import com.example.chat.model.Message;

public interface MessageService {

  void sendMessage(Message message);

  Message saveMessage(Message message);
}
