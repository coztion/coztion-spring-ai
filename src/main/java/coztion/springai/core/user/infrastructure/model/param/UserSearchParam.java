package coztion.springai.core.user.infrastructure.model.param;

import coztion.springai.core.user.application.model.command.UserSearchCommand;
import coztion.springai.core.user.infrastructure.mapper.UserParamMapper;
import java.util.List;
import lombok.Getter;

@Getter
public class UserSearchParam {

    private List<Long> userIds;

    private List<String> usernames;

    public static UserSearchParam fromCommand(UserSearchCommand command) {
        return UserParamMapper.INSTANCE.toParam(command);
    }
}
