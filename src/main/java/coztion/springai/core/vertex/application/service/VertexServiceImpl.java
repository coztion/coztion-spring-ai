package coztion.springai.core.vertex.application.service;

import coztion.springai.core.vertex.application.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
class VertexServiceImpl implements VertexService {

    private final VertexGeminiService geminiService;

    private final VertexImagenService imagenService;

    private final VertexClaudeService claudeService;

    @Override
    public Flux<VertexGenerateResult> generate(VertexGenerateCommand command) {
        if (command.isGemini()) {
            VertexGeminiGenerateCommand geminiGenerateCommand = command.toGeminiCommand();
            return geminiService.generate(geminiGenerateCommand).map(VertexGenerateResult::fromGemini);
        }

        if (command.isImagen()) {
            VertexImagenGenerateCommand imagenGenerateCommand = command.toImagenCommand();
            return imagenService
                    .generate(imagenGenerateCommand)
                    .map(VertexGenerateResult::fromImagen)
                    .flux();
        }

        if (command.isClaude()) {
            VertexClaudeGenerateCommand claudeGenerateCommand = command.toClaudeCommand();
            return claudeService.generate(claudeGenerateCommand).map(VertexGenerateResult::fromClaude);
        }

        return Flux.empty();
    }
}
