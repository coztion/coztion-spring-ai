package coztion.springai.core.vertex.application.mapper;

import coztion.springai.core.vertex.application.model.command.VertexClaudeGenerateCommand;
import coztion.springai.core.vertex.application.model.command.VertexGeminiGenerateCommand;
import coztion.springai.core.vertex.application.model.command.VertexGenerateCommand;
import coztion.springai.core.vertex.application.model.command.VertexImagenGenerateCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VertexCommandMapper {

    VertexCommandMapper INSTANCE = Mappers.getMapper(VertexCommandMapper.class);

    VertexGeminiGenerateCommand toGeminiCommand(VertexGenerateCommand command);

    VertexImagenGenerateCommand toImagenCommand(VertexGenerateCommand command);

    VertexClaudeGenerateCommand toClaudeCommand(VertexGenerateCommand command);
}
