package coztion.springai.core.ai.application.model.result;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class AiGenerateResult {

    @Builder.Default
    private boolean imageGenerated = false;

    private String generatedText;

    private List<String> generatedImages;

    public static AiGenerateResult ofText(String generatedText) {
        return AiGenerateResult.builder().generatedText(generatedText).build();
    }

    public static AiGenerateResult ofImages(List<String> generatedImages) {
        return AiGenerateResult.builder()
                .imageGenerated(true)
                .generatedImages(generatedImages)
                .build();
    }
}
