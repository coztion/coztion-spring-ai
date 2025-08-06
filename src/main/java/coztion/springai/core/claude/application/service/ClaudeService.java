package coztion.springai.core.claude.application.service;

import coztion.springai.core.claude.application.model.command.ClaudeGenerateCommand;
import coztion.springai.core.claude.application.model.result.ClaudeGenerateResult;
import reactor.core.publisher.Flux;

public interface ClaudeService {

    Flux<ClaudeGenerateResult> generate(ClaudeGenerateCommand command);
}
