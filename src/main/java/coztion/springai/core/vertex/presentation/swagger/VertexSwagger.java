package coztion.springai.core.vertex.presentation.swagger;

import coztion.springai.core.shared.presentation.model.RestResponse;
import coztion.springai.core.vertex.presentation.model.VertexGenerateRequest;
import coztion.springai.core.vertex.presentation.model.VertexGenerateResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;

@Tag(name = "Vertex AI", description = "Google Cloud Platform Vertex AI API")
public interface VertexSwagger {

    @Operation(description = "Generate Gemini content using Vertex AI")
    @RequestBody(
            description = "Gemini content generation prompt and configuration",
            required = true,
            content =
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = VertexGenerateRequest.class),
                            examples =
                                    @ExampleObject(
                                            value =
                                                    """
                                    {
                                      "prompt": {
                                        "text": "Explain about the image.",
                                        "files": [
                                            {
                                                "name": "architecture.png",
                                                "mimeType": "image/png",
                                                "data": "base64-encoded-image-data"
                                            }
                                        ]
                                      },
                                      "config": {
                                        "model": "gemini-2.5-flash",
                                        "location": "us-central1",
                                        "temperature": 1.0,
                                        "maxOutputTokens": 2048
                                      }
                                    }
                                    """)))
    Flux<RestResponse<VertexGenerateResponse>> generate(@Valid @RequestBody VertexGenerateRequest request);
}
