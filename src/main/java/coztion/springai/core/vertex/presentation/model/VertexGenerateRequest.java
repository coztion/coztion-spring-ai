package coztion.springai.core.vertex.presentation.model;

import coztion.springai.core.vertex.application.model.VertexGenerateCommand;
import coztion.springai.core.vertex.presentation.mapper.VertexRequestMapper;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VertexGenerateRequest {

    private GeneratePrompt prompt;

    private GenerateConfig config;

    public VertexGenerateCommand toCommand() {
        return VertexRequestMapper.INSTANCE.toCommand(this);
    }

    @Setter
    @Getter
    public static class GeneratePrompt {

        private String text;

        private List<GenerateFile> files;

        @Setter
        @Getter
        public static class GenerateFile {

            private String name;

            private String mimeType;

            private String data;
        }
    }

    @Setter
    @Getter
    public static class GenerateConfig {

        private String model;

        private String location;

        private double temperature;

        private int maxOutputTokens;
    }
}
