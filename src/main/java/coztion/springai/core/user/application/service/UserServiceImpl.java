package coztion.springai.core.user.application.service;

import coztion.springai.core.user.application.infra.UserRepository;
import coztion.springai.core.user.application.model.command.UserSearchCommand;
import coztion.springai.core.user.domain.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public Users searchUsers(UserSearchCommand searchCommand) {
        return userRepository.findUsersBySearchCommand(searchCommand);
    }
}
