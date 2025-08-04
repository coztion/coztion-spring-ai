package coztion.springai.core.vertex.application.model;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class VertexGenerateResult {

    @Builder.Default
    private boolean isImage = false;

    private String generatedText;

    private List<String> generatedImages;

    public static VertexGenerateResult fromGemini(VertexGeminiGenerateResult geminiResult) {
        return VertexGenerateResult.builder()
                .generatedText(geminiResult.getGeneratedText())
                .build();
    }

    public static VertexGenerateResult fromImagen(VertexImagenGenerateResult imagenResult) {
        return VertexGenerateResult.builder()
                .isImage(true)
                .generatedImages(imagenResult.getGeneratedImages())
                .build();
    }
}
