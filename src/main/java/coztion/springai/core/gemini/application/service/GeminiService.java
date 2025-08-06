package coztion.springai.core.gemini.application.service;

import coztion.springai.core.gemini.application.model.command.GeminiGenerateCommand;
import coztion.springai.core.gemini.application.model.result.GeminiGenerateResult;
import reactor.core.publisher.Flux;

public interface GeminiService {

    Flux<GeminiGenerateResult> generate(GeminiGenerateCommand generate);
}
