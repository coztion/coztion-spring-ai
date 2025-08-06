package coztion.springai.core.gemini.application.model.result;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class GeminiGenerateResult {

    @Builder.Default
    private boolean completed = false;

    private String generatedText;

    public static GeminiGenerateResult next(String generatedText) {
        return GeminiGenerateResult.builder()
                .completed(false)
                .generatedText(generatedText)
                .build();
    }

    public static GeminiGenerateResult complete(String generatedText) {
        return GeminiGenerateResult.builder()
                .completed(true)
                .generatedText(generatedText)
                .build();
    }
}
