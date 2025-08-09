package coztion.springai.core.chat.infrastructure.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import coztion.springai.core.chat.infrastructure.model.entity.ChatEntity;
import coztion.springai.core.chat.infrastructure.model.entity.QChatEntity;
import coztion.springai.core.chat.infrastructure.model.param.ChatSearchParam;
import coztion.springai.core.shared.infrastructure.repository.QueryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ChatQueryRepository implements QueryRepository {

    private final QChatEntity chat = QChatEntity.chatEntity;

    private final JPAQueryFactory queryFactory;

    public List<ChatEntity> findChatsBySearchParam(ChatSearchParam searchParam) {
        return queryFactory
                .selectFrom(chat)
                .where(
                        in(chat.chatId, searchParam.getChatIds()),
                        in(chat.sequence, searchParam.getSequences()),
                        in(chat.model, searchParam.getModels()),
                        equal(chat.isUser, searchParam.getIsUser()))
                .fetch();
    }
}
