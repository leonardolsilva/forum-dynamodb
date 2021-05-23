package br.com.lelecoder.forumdynamodb.core.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class Resposta {

    private final String identificadorResposta;
    private final String texto;
    private final LocalDateTime dataCriacao;
    private final Aluno aluno;
    private final boolean solucao;

    public boolean isSolucao() {
        return solucao;
    }
}
