package coztion.springai.core.chat.application.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatSearchCommand {

    private List<Long> chatIds;

    private List<Integer> sequences;

    private List<String> models;

    private Boolean isUser;
}
