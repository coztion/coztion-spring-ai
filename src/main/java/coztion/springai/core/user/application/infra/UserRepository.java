package coztion.springai.core.user.application.infra;

import coztion.springai.core.user.application.model.command.UserSearchCommand;
import coztion.springai.core.user.domain.Users;

public interface UserRepository {

    Users findUsersBySearchCommand(UserSearchCommand searchCommand);
}
