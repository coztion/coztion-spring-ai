package coztion.springai.core.ai.application.infra;

import coztion.springai.core.ai.application.model.command.AiGenerateCommand;
import coztion.springai.core.ai.application.model.result.AiGenerateResult;
import reactor.core.publisher.Flux;

public interface AiAdapter {

    Flux<AiGenerateResult> generateGemini(AiGenerateCommand command);

    Flux<AiGenerateResult> generateImagen(AiGenerateCommand command);

    Flux<AiGenerateResult> generateClaude(AiGenerateCommand command);
}
