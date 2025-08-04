package coztion.springai.core.vertex.application.mapper;

import coztion.springai.core.vertex.application.model.VertexGeminiGenerateCommand;
import coztion.springai.core.vertex.application.model.VertexGenerateCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VertexCommandMapper {

    VertexCommandMapper INSTANCE = Mappers.getMapper(VertexCommandMapper.class);

    VertexGeminiGenerateCommand toCommand(VertexGenerateCommand command);
}
