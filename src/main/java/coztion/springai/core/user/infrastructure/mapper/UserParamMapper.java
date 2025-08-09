package coztion.springai.core.user.infrastructure.mapper;

import coztion.springai.core.user.application.model.command.UserSearchCommand;
import coztion.springai.core.user.infrastructure.model.param.UserSearchParam;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserParamMapper {

    UserParamMapper INSTANCE = Mappers.getMapper(UserParamMapper.class);

    UserSearchParam toParam(UserSearchCommand command);
}
