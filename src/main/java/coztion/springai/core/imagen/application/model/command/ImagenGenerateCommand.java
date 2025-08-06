package coztion.springai.core.imagen.application.model.command;

import com.google.genai.types.GenerateImagesConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ImagenGenerateCommand {

    private ImagenPrompt prompt;

    private ImagenConfig config;

    public GenerateImagesConfig createConfig() {
        return config.createConfig();
    }

    public String getText() {
        return prompt.text;
    }

    public String getModel() {
        return config.model;
    }

    @Getter
    @Setter
    public static class ImagenPrompt {

        private String text;
    }

    @Getter
    @Setter
    public static class ImagenConfig {

        private String model;

        private String location;

        private int numberOfImages = 1;

        public GenerateImagesConfig createConfig() {
            return GenerateImagesConfig.builder().numberOfImages(numberOfImages).build();
        }
    }
}
