package coztion.springai.core.ai.presentation.swagger;

import coztion.springai.core.ai.presentation.model.request.AiGenerateRequest;
import coztion.springai.core.ai.presentation.model.response.VertexGenerateResponse;
import coztion.springai.core.shared.presentation.model.RestResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;

@Tag(name = "AI API Specs", description = "API specifications for AI operations")
public interface AiSwagger {

    @Operation(
            summary = "Generate AI Content",
            description = "Generates AI content based on the provided prompt and configuration.")
    @RequestBody(
            description = "Prompt and configuration for AI content generation",
            required = true,
            content =
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = AiGenerateRequest.class),
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
    Flux<RestResponse<VertexGenerateResponse>> generate(@Valid @RequestBody AiGenerateRequest request);
}
