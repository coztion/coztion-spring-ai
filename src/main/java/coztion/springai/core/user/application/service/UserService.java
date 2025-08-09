package coztion.springai.core.user.application.service;

import coztion.springai.core.user.application.model.command.UserSearchCommand;
import coztion.springai.core.user.domain.Users;

public interface UserService {

    Users searchUsers(UserSearchCommand searchCommand);
}
