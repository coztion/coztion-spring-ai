package coztion.springai.core.ai.application.service;

import coztion.springai.core.ai.application.model.command.AiGenerateCommand;
import coztion.springai.core.ai.application.model.result.AiGenerateResult;
import reactor.core.publisher.Flux;

public interface AiService {

    Flux<AiGenerateResult> generate(AiGenerateCommand command);
}
