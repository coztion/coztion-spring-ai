package coztion.springai.core.ai.application.service;

import coztion.springai.core.ai.application.infra.AiAdapter;
import coztion.springai.core.ai.application.model.command.AiGenerateCommand;
import coztion.springai.core.ai.application.model.result.AiGenerateResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
class AiServiceImpl implements AiService {

    private final AiAdapter aiAdapter;

    @Override
    public Flux<AiGenerateResult> generate(AiGenerateCommand command) {
        if (command.isGemini()) {
            return aiAdapter.generateGemini(command);
        }

        if (command.isImagen()) {
            return aiAdapter.generateImagen(command);
        }

        if (command.isClaude()) {
            return aiAdapter.generateClaude(command);
        }

        return Flux.empty();
    }
}
