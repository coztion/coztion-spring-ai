package coztion.springai.core.user.application.model.command;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchCommand {

    private List<Long> userIds;

    private List<String> usernames;
}
