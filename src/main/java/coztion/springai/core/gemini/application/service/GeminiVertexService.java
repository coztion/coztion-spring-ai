package coztion.springai.core.gemini.application.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.genai.Client;
import com.google.genai.ResponseStream;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import coztion.springai.core.gemini.application.model.command.GeminiGenerateCommand;
import coztion.springai.core.gemini.application.model.result.GeminiGenerateResult;
import java.io.IOException;
import java.util.Iterator;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
class GeminiVertexService {

    @Value("${cloud.gcp.project-id}")
    private String googleProjectId;

    @Value("${cloud.gcp.credentials.scope}")
    private String googleCredentialsScope;

    @SneakyThrows
    public Flux<GeminiGenerateResult> generate(GeminiGenerateCommand generate) {
        return Flux.create(emitter -> {
            try {
                GoogleCredentials googleCredentials =
                        GoogleCredentials.getApplicationDefault().createScoped(googleCredentialsScope);

                try (Client client = Client.builder()
                        .project(googleProjectId)
                        .location(generate.getLocation())
                        .vertexAI(true)
                        .credentials(googleCredentials)
                        .build()) {

                    String model = generate.getModel();
                    Content content = generate.createContent();
                    GenerateContentConfig config = generate.createConfig();

                    try (ResponseStream<GenerateContentResponse> generateContentResponses =
                            client.models.generateContentStream(model, content, config)) {
                        Iterator<GenerateContentResponse> iterator = generateContentResponses.iterator();

                        while (iterator.hasNext()) {
                            GenerateContentResponse generatedContentResponse = iterator.next();
                            String generatedText = generatedContentResponse.text();

                            GeminiGenerateResult vertexGeminiGenerateResult = iterator.hasNext()
                                    ? GeminiGenerateResult.next(generatedText)
                                    : GeminiGenerateResult.complete(generatedText);
                            emitter.next(vertexGeminiGenerateResult);
                        }
                    }
                }

                emitter.complete();
            } catch (IOException e) {
                emitter.error(e);
            }
        });
    }
}
