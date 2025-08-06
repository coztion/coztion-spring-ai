package coztion.springai.core.gemini.application.service;

import coztion.springai.core.gemini.application.model.command.GeminiGenerateCommand;
import coztion.springai.core.gemini.application.model.result.GeminiGenerateResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
class GeminiServiceImpl implements GeminiService {

    private final GeminiVertexService vertexService;

    @Override
    public Flux<GeminiGenerateResult> generate(GeminiGenerateCommand command) {
        return vertexService.generate(command);
    }
}
