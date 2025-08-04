package coztion.springai.core.vertex.presentation.model;

import coztion.springai.core.vertex.application.model.VertexGenerateResult;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class VertexGenerateResponse {

    private String answer;

    public static VertexGenerateResponse from(VertexGenerateResult result) {
        return VertexGenerateResponse.builder().answer(result.getAnswer()).build();
    }
}
