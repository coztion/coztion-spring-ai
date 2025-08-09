package coztion.springai.core.chat.application.infra;

import coztion.springai.core.chat.application.model.ChatSearchCommand;
import coztion.springai.core.chat.domain.Chats;

public interface ChatRepository {

    Chats findChatsBySearchCommand(ChatSearchCommand searchCommand);
}
