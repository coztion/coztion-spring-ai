package coztion.springai.core.vertex.application.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class VertexGenerateResult {

    private String answer;

    public static VertexGenerateResult fromGemini(VertexGeminiGenerateResult geminiResult) {
        return VertexGenerateResult.builder().answer(geminiResult.getAnswer()).build();
    }
}
