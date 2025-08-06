package coztion.springai.core.imagen.application.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.genai.Client;
import com.google.genai.types.*;
import coztion.springai.core.imagen.application.model.command.ImagenGenerateCommand;
import coztion.springai.core.imagen.application.model.result.ImagenGenerateResult;
import java.io.IOException;
import java.util.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
class ImagenVertexService {

    @Value("${genai.google.project-id}")
    private String googleProjectId;

    @Value("${genai.google.credentials.scope}")
    private String googleCredentialsScope;

    public Mono<ImagenGenerateResult> generate(ImagenGenerateCommand command) {
        return Mono.create(emitter -> {
            try {
                GoogleCredentials googleCredentials =
                        GoogleCredentials.getApplicationDefault().createScoped(googleCredentialsScope);

                try (Client client = Client.builder()
                        .project(googleProjectId)
                        .location(command.getModel())
                        .vertexAI(true)
                        .credentials(googleCredentials)
                        .build()) {

                    GenerateImagesResponse generateImagesResponse =
                            client.models.generateImages(command.getModel(), command.getText(), command.createConfig());

                    Optional<List<GeneratedImage>> generatedImages = generateImagesResponse.generatedImages();

                    List<String> images = generatedImages.orElse(Collections.emptyList()).stream()
                            .map(GeneratedImage::image)
                            .filter(Optional::isPresent)
                            .map(Optional::get)
                            .map(Image::imageBytes)
                            .filter(Optional::isPresent)
                            .map(Optional::get)
                            .map(a -> Base64.getEncoder().encodeToString(a))
                            .toList();

                    emitter.success(ImagenGenerateResult.complete(images));
                }

            } catch (IOException e) {
                emitter.error(e);
            }
        });
    }
}
