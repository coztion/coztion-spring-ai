package coztion.springai.core.ai.presentation.controller;

import coztion.springai.core.ai.application.model.command.AiGenerateCommand;
import coztion.springai.core.ai.application.service.AiService;
import coztion.springai.core.ai.presentation.model.request.AiGenerateRequest;
import coztion.springai.core.ai.presentation.model.response.VertexGenerateResponse;
import coztion.springai.core.ai.presentation.swagger.AiSwagger;
import coztion.springai.core.shared.presentation.model.RestResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ai")
public class AiController implements AiSwagger {

    private final AiService aiService;

    @PostMapping(value = "/generate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @Override
    public Flux<RestResponse<VertexGenerateResponse>> generate(@Valid @RequestBody AiGenerateRequest request) {
        AiGenerateCommand command = request.toCommand();
        return aiService
                .generate(command)
                .map(VertexGenerateResponse::fromResult)
                .map(RestResponse::of);
    }
}
