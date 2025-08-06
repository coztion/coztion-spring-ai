package coztion.springai.core.imagen.application.service;

import coztion.springai.core.imagen.application.model.command.ImagenGenerateCommand;
import coztion.springai.core.imagen.application.model.result.ImagenGenerateResult;
import reactor.core.publisher.Mono;

public interface ImagenService {

    Mono<ImagenGenerateResult> generate(ImagenGenerateCommand command);
}
