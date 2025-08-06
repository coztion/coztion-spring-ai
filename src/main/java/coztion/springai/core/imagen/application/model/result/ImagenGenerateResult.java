package coztion.springai.core.imagen.application.model.result;

import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class ImagenGenerateResult {

    @Builder.Default
    private boolean completed = false;

    private List<String> generatedImages;

    public static ImagenGenerateResult complete(List<String> generatedImages) {
        return ImagenGenerateResult.builder().generatedImages(generatedImages).build();
    }
}
