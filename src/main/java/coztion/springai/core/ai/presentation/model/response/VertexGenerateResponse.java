package coztion.springai.core.ai.presentation.model.response;

import coztion.springai.core.ai.application.model.result.AiGenerateResult;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class VertexGenerateResponse {

    private boolean imageGenerated;

    private String generatedText;

    private List<String> generatedImages;

    public static VertexGenerateResponse fromResult(AiGenerateResult result) {
        return VertexGenerateResponse.builder()
                .imageGenerated(result.isImageGenerated())
                .generatedText(result.getGeneratedText())
                .generatedImages(result.getGeneratedImages())
                .build();
    }
}
