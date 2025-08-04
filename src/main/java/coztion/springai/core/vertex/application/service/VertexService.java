package coztion.springai.core.vertex.application.service;

import coztion.springai.core.vertex.application.model.VertexGenerateCommand;
import coztion.springai.core.vertex.application.model.VertexGenerateResult;
import reactor.core.publisher.Flux;

public interface VertexService {

    Flux<VertexGenerateResult> generate(VertexGenerateCommand command);
}
