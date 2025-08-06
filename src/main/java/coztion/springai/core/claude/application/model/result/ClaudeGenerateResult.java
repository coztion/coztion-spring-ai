package coztion.springai.core.claude.application.model.result;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class ClaudeGenerateResult {

    @Builder.Default
    private boolean completed = false;

    private String generatedText;

    public static ClaudeGenerateResult next(String generatedText) {
        return ClaudeGenerateResult.builder()
                .completed(false)
                .generatedText(generatedText)
                .build();
    }

    public static ClaudeGenerateResult complete(String generatedText) {
        return ClaudeGenerateResult.builder()
                .completed(true)
                .generatedText(generatedText)
                .build();
    }
}
