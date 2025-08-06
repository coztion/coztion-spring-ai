package coztion.springai.core.ai.infrastructure.mapper;

import coztion.springai.core.ai.application.model.command.AiGenerateCommand;
import coztion.springai.core.claude.application.model.command.ClaudeGenerateCommand;
import coztion.springai.core.gemini.application.model.command.GeminiGenerateCommand;
import coztion.springai.core.imagen.application.model.command.ImagenGenerateCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AiAdapterMapper {

    AiAdapterMapper INSTANCE = Mappers.getMapper(AiAdapterMapper.class);

    GeminiGenerateCommand toGeminiGenerateCommand(AiGenerateCommand command);

    ImagenGenerateCommand toImagenGenerateCommand(AiGenerateCommand command);

    ClaudeGenerateCommand toClaudeGenerateCommand(AiGenerateCommand command);
}
