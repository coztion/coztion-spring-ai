package coztion.springai.core.vertex.presentation.mapper;

import coztion.springai.core.vertex.application.model.command.VertexGenerateCommand;
import coztion.springai.core.vertex.presentation.model.request.VertexGenerateRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VertexRequestMapper {

    VertexRequestMapper INSTANCE = Mappers.getMapper(VertexRequestMapper.class);

    VertexGenerateCommand toCommand(VertexGenerateRequest request);
}
