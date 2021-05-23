package br.com.lelecoder.forumdynamodb.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Getter
@Builder
public class Topico {

    private final String identificadorTopico;
    private final String titulo;
    private final String mensagem;
    private final String categoria;
    private final LocalDateTime dataCriacao;
    private final SituacaoTopico status;
    private final Aluno autor;
    private final Disciplina disciplina;
    private final List<Resposta> respostas;

    public Optional<Resposta> getRespostaSolucionadora() {
        return this.respostas
                .stream()
                .filter(Resposta::isSolucao)
                .findFirst();
    }

    public void adicionarResposta(Resposta resposta) {
        this.respostas.add(resposta);
    }
}