package coztion.springai.core.chat.infrastructure.repository;

import coztion.springai.core.chat.application.infra.ChatRepository;
import coztion.springai.core.chat.application.model.ChatSearchCommand;
import coztion.springai.core.chat.domain.Chat;
import coztion.springai.core.chat.domain.Chats;
import coztion.springai.core.chat.infrastructure.model.entity.ChatEntity;
import coztion.springai.core.chat.infrastructure.model.param.ChatSearchParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class ChatRepositoryImpl implements ChatRepository {

    private final ChatQueryRepository queryRepository;

    @Override
    public Chats findChatsBySearchCommand(ChatSearchCommand searchCommand) {
        ChatSearchParam searchParam = ChatSearchParam.fromCommand(searchCommand);
        List<ChatEntity> foundChatEntities = queryRepository.findChatsBySearchParam(searchParam);
        List<Chat> foundChats =
                foundChatEntities.stream().map(ChatEntity::toDomain).toList();
        return new Chats(foundChats);
    }
}
