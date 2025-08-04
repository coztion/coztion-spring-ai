package coztion.springai.core.vertex.application.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class VertexGeminiGenerateResult {

    @Builder.Default
    private boolean completed = false;

    private String answer;

    public static VertexGeminiGenerateResult next(String answer) {
        return VertexGeminiGenerateResult.builder()
                .completed(false)
                .answer(answer)
                .build();
    }

    public static VertexGeminiGenerateResult complete(String answer) {
        return VertexGeminiGenerateResult.builder()
                .completed(true)
                .answer(answer)
                .build();
    }
}
