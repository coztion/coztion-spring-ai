package coztion.springai.core.vertex.presentation.controller;

import coztion.springai.core.shared.presentation.model.RestResponse;
import coztion.springai.core.vertex.application.model.command.VertexGenerateCommand;
import coztion.springai.core.vertex.application.service.VertexService;
import coztion.springai.core.vertex.presentation.model.request.VertexGenerateRequest;
import coztion.springai.core.vertex.presentation.model.response.VertexGenerateResponse;
import coztion.springai.core.vertex.presentation.swagger.VertexSwagger;
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
@RequestMapping("/vertex")
public class VertexController implements VertexSwagger {

    private final VertexService vertexService;

    @PostMapping(value = "/generate", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @Override
    public Flux<RestResponse<VertexGenerateResponse>> generate(@Valid @RequestBody VertexGenerateRequest request) {
        VertexGenerateCommand command = request.toCommand();
        return vertexService.generate(command).map(VertexGenerateResponse::from).map(RestResponse::of);
    }
}
