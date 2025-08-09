package coztion.springai.core.user.infrastructure.repository;

import coztion.springai.core.user.application.infra.UserRepository;
import coztion.springai.core.user.application.model.command.UserSearchCommand;
import coztion.springai.core.user.domain.User;
import coztion.springai.core.user.domain.Users;
import coztion.springai.core.user.infrastructure.model.entity.UserEntity;
import coztion.springai.core.user.infrastructure.model.param.UserSearchParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class UserRepositoryImpl implements UserRepository {

    private final UserQueryRepository queryRepository;

    @Override
    public Users findUsersBySearchCommand(UserSearchCommand searchCommand) {
        UserSearchParam userSearchParam = UserSearchParam.fromCommand(searchCommand);
        List<UserEntity> foundUserEntities = queryRepository.findUsersBySearchParam(userSearchParam);
        List<User> foundUsers =
                foundUserEntities.stream().map(UserEntity::toDomain).toList();
        return new Users(foundUsers);
    }
}
