package coztion.springai.core.vertex.application.model;

import com.anthropic.models.messages.*;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VertexClaudeGenerateCommand {

    private VertexClaudePrompt prompt;

    private VertexClaudeConfig config;

    public MessageCreateParams createMessageCreateParams() {
        return MessageCreateParams.builder()
                .addUserMessage(prompt.createMessageParamContent())
                .model(config.model)
                .temperature(config.temperature)
                .maxTokens(config.maxOutputTokens)
                .build();
    }

    public String getConfigLocation() {
        return config.location;
    }

    @Getter
    @Setter
    public static class VertexClaudePrompt {

        private String text;

        private List<VertexClaudeFile> files;

        public MessageParam.Content createMessageParamContent() {
            ContentBlockParam textContentBlockParam = createTextContentBlockParam();

            List<ContentBlockParam> imageContentBlockParams =
                    Optional.ofNullable(files).orElse(Collections.emptyList()).stream()
                            .map(VertexClaudeFile::createImageContentBlockParam)
                            .toList();

            List<ContentBlockParam> contentBlockParams = Stream.concat(
                            Stream.of(textContentBlockParam), imageContentBlockParams.stream())
                    .toList();

            return MessageParam.Content.ofBlockParams(contentBlockParams);
        }

        private ContentBlockParam createTextContentBlockParam() {
            return ContentBlockParam.ofText(TextBlockParam.builder().text(text).build());
        }

        @Getter
        @Setter
        public static class VertexClaudeFile {

            private String name;

            private String mimeType;

            private String data;

            public ContentBlockParam createImageContentBlockParam() {
                return ContentBlockParam.ofImage(ImageBlockParam.builder()
                        .source(Base64ImageSource.builder()
                                .data(data)
                                .mediaType(Base64ImageSource.MediaType.of(mimeType))
                                .build())
                        .build());
            }
        }
    }

    @Getter
    @Setter
    public static class VertexClaudeConfig {

        private String model;

        private String location;

        private double temperature;

        private int maxOutputTokens;
    }
}
