package coztion.springai.core.claude.application.service;

import coztion.springai.core.claude.application.model.command.ClaudeGenerateCommand;
import coztion.springai.core.claude.application.model.result.ClaudeGenerateResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
class ClaudeServiceImpl implements ClaudeService {

    private final ClaudeVertexService vertexService;

    @Override
    public Flux<ClaudeGenerateResult> generate(ClaudeGenerateCommand command) {
        return vertexService.generate(command);
    }
}
