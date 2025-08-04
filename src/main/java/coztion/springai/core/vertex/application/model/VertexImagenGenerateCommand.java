package coztion.springai.core.vertex.application.model;

import com.google.genai.types.GenerateImagesConfig;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VertexImagenGenerateCommand {

    private VertexImagenPrompt prompt;

    private VertexImagenConfig config;

    public GenerateImagesConfig createConfig() {
        return config.createConfig();
    }

    public String getPromptText() {
        return prompt.text;
    }

    public String getConfigModel() {
        return config.model;
    }

    @Getter
    @Setter
    public static class VertexImagenPrompt {

        private String text;
    }

    @Getter
    @Setter
    public static class VertexImagenConfig {

        private String model;

        private String location;

        private int sampleCount = 1;

        public GenerateImagesConfig createConfig() {
            return GenerateImagesConfig.builder().numberOfImages(sampleCount).build();
        }
    }
}
