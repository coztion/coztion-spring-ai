package coztion.springai.core.vertex.presentation.model;

import coztion.springai.core.vertex.application.model.VertexGenerateResult;
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

    public static VertexGenerateResponse from(VertexGenerateResult result) {
        return VertexGenerateResponse.builder()
                .imageGenerated(result.isImageGenerated())
                .generatedText(result.getGeneratedText())
                .generatedImages(result.getGeneratedImages())
                .build();
    }
}
