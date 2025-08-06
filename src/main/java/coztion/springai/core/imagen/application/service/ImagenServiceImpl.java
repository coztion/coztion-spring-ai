package coztion.springai.core.imagen.application.service;

import coztion.springai.core.imagen.application.model.command.ImagenGenerateCommand;
import coztion.springai.core.imagen.application.model.result.ImagenGenerateResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
class ImagenServiceImpl implements ImagenService {

    private final ImagenVertexService vertexService;

    @Override
    public Mono<ImagenGenerateResult> generate(ImagenGenerateCommand command) {
        return vertexService.generate(command);
    }
}
