package coztion.springai.core.vertex.application.model;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class VertexGenerateResult {

    @Builder.Default
    private boolean imageGenerated = false;

    private String generatedText;

    private List<String> generatedImages;

    public static VertexGenerateResult fromGemini(VertexGeminiGenerateResult geminiResult) {
        return VertexGenerateResult.builder()
                .generatedText(geminiResult.getGeneratedText())
                .build();
    }

    public static VertexGenerateResult fromImagen(VertexImagenGenerateResult imagenResult) {
        return VertexGenerateResult.builder()
                .imageGenerated(true)
                .generatedImages(imagenResult.getGeneratedImages())
                .build();
    }

    public static VertexGenerateResult fromClaude(VertexClaudeGenerateResult claudeResult) {
        return VertexGenerateResult.builder()
                .generatedText(claudeResult.getGeneratedText())
                .build();
    }
}
