package coztion.springai.core.vertex.application.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class VertexGeminiGenerateResult {

    @Builder.Default
    private boolean completed = false;

    private String generatedText;

    public static VertexGeminiGenerateResult next(String generatedText) {
        return VertexGeminiGenerateResult.builder()
                .completed(false)
                .generatedText(generatedText)
                .build();
    }

    public static VertexGeminiGenerateResult complete(String generatedText) {
        return VertexGeminiGenerateResult.builder()
                .completed(true)
                .generatedText(generatedText)
                .build();
    }
}
