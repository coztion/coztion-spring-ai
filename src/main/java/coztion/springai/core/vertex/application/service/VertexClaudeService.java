package coztion.springai.core.vertex.application.service;

import com.anthropic.client.AnthropicClient;
import com.anthropic.client.okhttp.AnthropicOkHttpClient;
import com.anthropic.core.http.StreamResponse;
import com.anthropic.models.messages.MessageCreateParams;
import com.anthropic.models.messages.RawMessageStreamEvent;
import com.anthropic.models.messages.TextDelta;
import com.anthropic.vertex.backends.VertexBackend;
import com.google.auth.oauth2.GoogleCredentials;
import coztion.springai.core.vertex.application.model.VertexClaudeGenerateCommand;
import coztion.springai.core.vertex.application.model.VertexClaudeGenerateResult;
import java.io.IOException;
import java.util.Iterator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class VertexClaudeService {

    @Value("${genai.google.project-id}")
    private String googleProjectId;

    @Value("${genai.google.credentials.scope}")
    private String googleCredentialsScope;

    public Flux<VertexClaudeGenerateResult> generate(VertexClaudeGenerateCommand command) {
        return Flux.create(emitter -> {
            try {
                GoogleCredentials googleCredentials =
                        GoogleCredentials.getApplicationDefault().createScoped(googleCredentialsScope);

                AnthropicClient client = AnthropicOkHttpClient.builder()
                        .backend(VertexBackend.builder()
                                .project(googleProjectId)
                                .googleCredentials(googleCredentials)
                                .region(command.getConfigLocation())
                                .build())
                        .build();

                MessageCreateParams messageCreateParams = command.createMessageCreateParams();

                try (StreamResponse<RawMessageStreamEvent> rawMessageStreamEvent =
                        client.messages().createStreaming(messageCreateParams)) {
                    Iterator<TextDelta> iterator = rawMessageStreamEvent.stream()
                            .flatMap(event -> event.contentBlockDelta().stream())
                            .flatMap(event -> event.delta().text().stream())
                            .iterator();

                    while (iterator.hasNext()) {
                        String generatedText = iterator.next().text();

                        VertexClaudeGenerateResult result = iterator.hasNext()
                                ? VertexClaudeGenerateResult.next(generatedText)
                                : VertexClaudeGenerateResult.complete(generatedText);

                        emitter.next(result);
                    }
                }

                emitter.complete();
            } catch (IOException e) {
                emitter.error(e);
            }
        });
    }
}
