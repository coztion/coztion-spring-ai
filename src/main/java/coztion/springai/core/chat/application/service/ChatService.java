package coztion.springai.core.chat.application.service;

import coztion.springai.core.chat.application.model.ChatSearchCommand;
import coztion.springai.core.chat.domain.Chats;
import org.springframework.transaction.annotation.Transactional;

public interface ChatService {
    @Transactional
    Chats searchChats(ChatSearchCommand command);
}
