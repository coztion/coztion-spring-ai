package coztion.springai.core.vertex.application.model.result;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class VertexClaudeGenerateResult {

    @Builder.Default
    private boolean completed = false;

    private String generatedText;

    public static VertexClaudeGenerateResult next(String generatedText) {
        return VertexClaudeGenerateResult.builder()
                .completed(false)
                .generatedText(generatedText)
                .build();
    }

    public static VertexClaudeGenerateResult complete(String generatedText) {
        return VertexClaudeGenerateResult.builder()
                .completed(true)
                .generatedText(generatedText)
                .build();
    }
}
