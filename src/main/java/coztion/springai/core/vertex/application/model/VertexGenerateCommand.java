package coztion.springai.core.vertex.application.model;

import coztion.springai.core.vertex.application.mapper.VertexCommandMapper;
import java.util.List;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VertexGenerateCommand {

    private GeneratePrompt prompt;

    private GenerateConfig config;

    public VertexGeminiGenerateCommand toGeminiCommand() {
        return VertexCommandMapper.INSTANCE.toCommand(this);
    }

    public boolean isGemini() {
        return config.model.startsWith("gemini");
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

        private double temperature;

        private int maxOutputTokens;
    }
}
