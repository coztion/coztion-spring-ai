package coztion.springai.core.vertex.application.model.command;

import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.Part;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VertexGeminiGenerateCommand {

    private VertexGeminiPrompt prompt;

    private VertexGeminiConfig config;

    public Content createContent() {
        return prompt.createContent();
    }

    public GenerateContentConfig createConfig() {
        return config.createConfig();
    }

    public String getModel() {
        return config.model;
    }

    @Getter
    @Setter
    public static class VertexGeminiPrompt {

        private String text;

        private List<VertexGeminiFile> files;

        public Content createContent() {
            Part textPart = Part.builder().text(text).build();

            List<Part> fileParts = Optional.ofNullable(files).orElse(Collections.emptyList()).stream()
                    .map(VertexGeminiFile::toPart)
                    .toList();

            List<Part> parts =
                    Stream.concat(Stream.of(textPart), fileParts.stream()).toList();

            return Content.builder().parts(parts).role("user").build();
        }

        @Getter
        @Setter
        public static class VertexGeminiFile {

            private String name;

            private String mimeType;

            private String data;

            public Part toPart() {
                return Part.fromBytes(getDataBytes(), mimeType);
            }

            private byte[] getDataBytes() {
                return Base64.getDecoder().decode(data);
            }
        }
    }

    @Getter
    @Setter
    public static class VertexGeminiConfig {

        private String model;

        private String location;

        private double temperature;

        private int maxOutputTokens;

        public GenerateContentConfig createConfig() {
            return GenerateContentConfig.builder()
                    .temperature((float) temperature)
                    .maxOutputTokens(maxOutputTokens)
                    .build();
        }
    }
}
