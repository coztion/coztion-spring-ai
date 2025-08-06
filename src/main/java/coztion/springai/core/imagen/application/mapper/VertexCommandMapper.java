package coztion.springai.core.imagen.application.mapper;

import coztion.springai.core.ai.application.model.command.AiGenerateCommand;
import coztion.springai.core.imagen.application.model.command.ImagenGenerateCommand;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VertexCommandMapper {

    VertexCommandMapper INSTANCE = Mappers.getMapper(VertexCommandMapper.class);

    ImagenGenerateCommand toImagenCommand(AiGenerateCommand command);
}
