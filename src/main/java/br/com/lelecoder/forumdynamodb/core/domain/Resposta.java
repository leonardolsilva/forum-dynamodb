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
    private boolean solucao;

    public void marcarRespostaSolucionada() {
        this.solucao = true;
    }

    public boolean isSolucao() {
        return solucao;
    }
}
