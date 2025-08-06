package coztion.springai.core.ai.application.model.command;

import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AiGenerateCommand {

    private GeneratePrompt prompt;

    private GenerateConfig config;

    public boolean isGemini() {
        return config.model.startsWith("gemini");
    }

    public boolean isImagen() {
        return config.model.startsWith("imagen");
    }

    public boolean isClaude() {
        return config.model.startsWith("claude");
    }

    @Getter
    @Setter
    public static class GeneratePrompt {

        private String text;

        private List<GenerateFile> files;

        @Getter
        @Setter
        public static class GenerateFile {

            private String name;

            private String mimeType;

            private String data;
        }
    }

    @Getter
    @Setter
    public static class GenerateConfig {

        private String model;

        private String location;

        private Double temperature;

        private Integer maxOutputTokens;

        private Integer numberOfImages;
    }
}
