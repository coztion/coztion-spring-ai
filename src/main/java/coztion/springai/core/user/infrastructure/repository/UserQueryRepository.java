package coztion.springai.core.user.infrastructure.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import coztion.springai.core.shared.infrastructure.repository.QueryRepository;
import coztion.springai.core.user.infrastructure.model.entity.QUserEntity;
import coztion.springai.core.user.infrastructure.model.entity.UserEntity;
import coztion.springai.core.user.infrastructure.model.param.UserSearchParam;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
class UserQueryRepository implements QueryRepository {

    private final QUserEntity user = QUserEntity.userEntity;

    private final JPAQueryFactory queryFactory;

    public List<UserEntity> findUsersBySearchParam(UserSearchParam param) {
        return queryFactory
                .selectFrom(user)
                .where(in(user.userId, param.getUserIds()), in(user.username, param.getUsernames()))
                .fetch();
    }
}
