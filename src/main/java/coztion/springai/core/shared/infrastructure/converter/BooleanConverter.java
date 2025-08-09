package coztion.springai.core.shared.infrastructure.converter;

import coztion.springai.common.Constant;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import java.util.Objects;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }

        return attribute ? Constant.YES : Constant.NO;
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }

        return Constant.YES.equals(dbData);
    }
}
