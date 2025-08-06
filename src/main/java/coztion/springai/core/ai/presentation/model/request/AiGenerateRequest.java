package coztion.springai.core.ai.presentation.model.request;

import coztion.springai.core.ai.application.model.command.AiGenerateCommand;
import coztion.springai.core.ai.presentation.mapper.AiRequestMapper;
import jakarta.validation.constraints.NotBlank;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AiGenerateRequest {

    private AiGeneratePrompt prompt;

    private AiGenerateConfig config;

    public AiGenerateCommand toCommand() {
        return AiRequestMapper.INSTANCE.toCommand(this);
    }

    @Setter
    @Getter
    public static class AiGeneratePrompt {

        @NotBlank
        private String text;

        private List<AiGenerateFile> files;

        @Setter
        @Getter
        public static class AiGenerateFile {

            private String name;

            private String mimeType;

            private String data;
        }
    }

    @Setter
    @Getter
    public static class AiGenerateConfig {

        @NotBlank
        private String model;

        @NotBlank
        private String location;

        private Double temperature;

        private Integer maxOutputTokens;

        private Integer numberOfImages;
    }
}
