package coztion.springai.core.chat.infrastructure.model.param;

import coztion.springai.core.chat.application.model.ChatSearchCommand;
import coztion.springai.core.chat.infrastructure.mapper.ChatParamMapper;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatSearchParam {

    private List<Long> chatIds;

    private List<Integer> sequences;

    private List<String> models;

    private Boolean isUser;

    public static ChatSearchParam fromCommand(ChatSearchCommand command) {
        return ChatParamMapper.INSTANCE.toParam(command);
    }
}
