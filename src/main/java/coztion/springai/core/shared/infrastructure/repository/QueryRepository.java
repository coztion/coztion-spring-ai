package coztion.springai.core.shared.infrastructure.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.SimpleExpression;
import java.util.List;
import java.util.Objects;

public interface QueryRepository {

    default <T> BooleanExpression in(SimpleExpression<T> expression, List<T> inValues) {
        if (Objects.isNull(inValues) || inValues.isEmpty()) {
            return null;
        }

        return expression.in(inValues.stream().distinct().toList());
    }

    default <T> BooleanExpression equal(SimpleExpression<T> expression, T value) {
        if (Objects.isNull(value)) {
            return null;
        }

        return expression.eq(value);
    }
}
