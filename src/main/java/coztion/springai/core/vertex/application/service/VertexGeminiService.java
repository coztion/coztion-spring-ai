package coztion.springai.core.vertex.application.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.genai.Client;
import com.google.genai.ResponseStream;
import com.google.genai.types.Content;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import coztion.springai.core.vertex.application.model.VertexGeminiGenerateCommand;
import coztion.springai.core.vertex.application.model.VertexGeminiGenerateResult;
import java.io.IOException;
import java.util.Iterator;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class VertexGeminiService {

    @Value("${genai.google.project-id}")
    private String googleProjectId;

    @Value("${genai.google.location}")
    private String googleLocation;

    @Value("${genai.google.credentials.scope}")
    private String googleCredentialsScope;

    @SneakyThrows
    public Flux<VertexGeminiGenerateResult> generate(VertexGeminiGenerateCommand command) {
        return Flux.create(emitter -> {
            try {
                GoogleCredentials googleCredentials =
                        GoogleCredentials.getApplicationDefault().createScoped(googleCredentialsScope);

                try (Client client = Client.builder()
                        .project(googleProjectId)
                        .location(googleLocation)
                        .vertexAI(true)
                        .credentials(googleCredentials)
                        .build()) {

                    String model = command.getModel();
                    Content content = command.createContent();
                    GenerateContentConfig config = command.createConfig();

                    try (ResponseStream<GenerateContentResponse> generateContentResponses =
                            client.models.generateContentStream(model, content, config)) {
                        Iterator<GenerateContentResponse> iterator = generateContentResponses.iterator();

                        while (iterator.hasNext()) {
                            GenerateContentResponse generatedContentResponse = iterator.next();
                            String generatedText = generatedContentResponse.text();

                            VertexGeminiGenerateResult vertexGeminiGenerateResult = iterator.hasNext()
                                    ? VertexGeminiGenerateResult.next(generatedText)
                                    : VertexGeminiGenerateResult.complete(generatedText);
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
