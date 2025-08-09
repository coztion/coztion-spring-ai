package coztion.springai.core.chat.infrastructure.mapper;

import coztion.springai.core.chat.application.model.ChatSearchCommand;
import coztion.springai.core.chat.infrastructure.model.param.ChatSearchParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChatParamMapper {

    ChatParamMapper INSTANCE = Mappers.getMapper(ChatParamMapper.class);

    ChatSearchParam toParam(ChatSearchCommand command);
}
