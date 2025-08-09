package coztion.springai.core.user.infrastructure.mapper;

import coztion.springai.core.user.domain.User;
import coztion.springai.core.user.infrastructure.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserEntityMapper {

    UserEntityMapper INSTANCE = Mappers.getMapper(UserEntityMapper.class);

    User toDomain(UserEntity entity);
}
