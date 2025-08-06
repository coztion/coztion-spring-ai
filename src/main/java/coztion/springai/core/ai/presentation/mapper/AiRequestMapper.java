package coztion.springai.core.ai.presentation.mapper;

import coztion.springai.core.ai.application.model.command.AiGenerateCommand;
import coztion.springai.core.ai.presentation.model.request.AiGenerateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AiRequestMapper {

    AiRequestMapper INSTANCE = Mappers.getMapper(AiRequestMapper.class);

    AiGenerateCommand toCommand(AiGenerateRequest request);
}
