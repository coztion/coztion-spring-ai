package coztion.springai.core.vertex.application.model.result;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class VertexImagenGenerateResult {

    @Builder.Default
    private boolean completed = false;

    private List<String> generatedImages;

    public static VertexImagenGenerateResult complete(List<String> generatedImages) {
        return VertexImagenGenerateResult.builder()
                .generatedImages(generatedImages)
                .build();
    }
}
