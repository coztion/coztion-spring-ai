package coztion.springai.core.shared.presentation.model;

import lombok.*;

@Getter
@Setter
@Builder(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T> {

    private RestResponseType type;

    private T value;

    public static <T> RestResponse<T> of(T value) {
        return RestResponse.<T>builder()
                .type(RestResponseType.SUCCESS)
                .value(value)
                .build();
    }
}
