package coztion.springai.core.chat.application.service;

import coztion.springai.core.chat.application.infra.ChatRepository;
import coztion.springai.core.chat.application.model.ChatSearchCommand;
import coztion.springai.core.chat.domain.Chats;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    @Transactional(readOnly = true)
    @Override
    public Chats searchChats(ChatSearchCommand command) {
        return chatRepository.findChatsBySearchCommand(command);
    }
}
