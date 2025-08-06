package coztion.springai.core.ai.infrastructure.adapter;

import coztion.springai.core.ai.application.infra.AiAdapter;
import coztion.springai.core.ai.application.model.command.AiGenerateCommand;
import coztion.springai.core.ai.application.model.result.AiGenerateResult;
import coztion.springai.core.ai.infrastructure.mapper.AiAdapterMapper;
import coztion.springai.core.claude.application.model.command.ClaudeGenerateCommand;
import coztion.springai.core.claude.application.service.ClaudeService;
import coztion.springai.core.gemini.application.model.command.GeminiGenerateCommand;
import coztion.springai.core.gemini.application.service.GeminiService;
import coztion.springai.core.imagen.application.model.command.ImagenGenerateCommand;
import coztion.springai.core.imagen.application.service.ImagenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
class AiAdapterImpl implements AiAdapter {

    private final GeminiService geminiService;

    private final ImagenService imagenService;

    private final ClaudeService claudeService;

    @Override
    public Flux<AiGenerateResult> generateGemini(AiGenerateCommand command) {
        GeminiGenerateCommand geminiGenerateCommand = AiAdapterMapper.INSTANCE.toGeminiGenerateCommand(command);
        return geminiService
                .generate(geminiGenerateCommand)
                .map(result -> AiGenerateResult.ofText(result.getGeneratedText()));
    }

    @Override
    public Flux<AiGenerateResult> generateImagen(AiGenerateCommand command) {
        ImagenGenerateCommand imagenGenerateCommand = AiAdapterMapper.INSTANCE.toImagenGenerateCommand(command);
        return imagenService
                .generate(imagenGenerateCommand)
                .map(result -> AiGenerateResult.ofImages(result.getGeneratedImages()))
                .flux();
    }

    @Override
    public Flux<AiGenerateResult> generateClaude(AiGenerateCommand command) {
        ClaudeGenerateCommand claudeGenerateCommand = AiAdapterMapper.INSTANCE.toClaudeGenerateCommand(command);
        return claudeService
                .generate(claudeGenerateCommand)
                .map(result -> AiGenerateResult.ofText(result.getGeneratedText()));
    }
}
