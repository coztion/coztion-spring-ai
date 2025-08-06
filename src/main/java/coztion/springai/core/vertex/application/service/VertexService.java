package coztion.springai.core.vertex.application.service;

import coztion.springai.core.vertex.application.model.command.VertexGenerateCommand;
import coztion.springai.core.vertex.application.model.result.VertexGenerateResult;
import reactor.core.publisher.Flux;

public interface VertexService {

    Flux<VertexGenerateResult> generate(VertexGenerateCommand command);
}
