package coztion.springai.core.vertex.application.service;

import coztion.springai.core.vertex.application.model.VertexGeminiGenerateCommand;
import coztion.springai.core.vertex.application.model.VertexGenerateCommand;
import coztion.springai.core.vertex.application.model.VertexGenerateResult;
import coztion.springai.core.vertex.application.model.VertexImagenGenerateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
class VertexServiceImpl implements VertexService {

    private final VertexGeminiService geminiService;

    private final VertexImagenService imagenService;

    @Override
    public Flux<VertexGenerateResult> generate(VertexGenerateCommand command) {
        if (command.isGemini()) {
            VertexGeminiGenerateCommand geminiGenerateCommand = command.toGeminiCommand();
            return geminiService.generate(geminiGenerateCommand).map(VertexGenerateResult::fromGemini);
        }

        VertexImagenGenerateCommand imagenGenerateCommand = command.toImagenCommand();
        return imagenService
                .generate(imagenGenerateCommand)
                .map(VertexGenerateResult::fromImagen)
                .flux();
    }
}
