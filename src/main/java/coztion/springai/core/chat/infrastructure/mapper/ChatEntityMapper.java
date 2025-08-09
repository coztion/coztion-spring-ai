package coztion.springai.core.chat.infrastructure.mapper;

import coztion.springai.core.chat.domain.Chat;
import coztion.springai.core.chat.infrastructure.model.entity.ChatEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatEntityMapper {

    ChatEntityMapper INSTANCE = Mappers.getMapper(ChatEntityMapper.class);

    Chat toDomain(ChatEntity chat);
}
