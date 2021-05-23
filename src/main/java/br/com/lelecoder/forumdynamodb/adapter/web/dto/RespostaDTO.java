package br.com.lelecoder.forumdynamodb.adapter.web.dto;

import br.com.lelecoder.forumdynamodb.core.domain.Resposta;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder(access = AccessLevel.PUBLIC)
@NoArgsConstructor
@AllArgsConstructor
public class RespostaDTO {

    private String texto;

    @JsonProperty("data_criacao")
    private LocalDateTime dataCriacao;

    private AlunoDTO aluno;

    public static RespostaDTO construirDTO(Resposta resposta) {
        return RespostaDTO
                .builder()
                .texto(resposta.getTexto())
                .dataCriacao(resposta.getDataCriacao())
                .aluno(AlunoDTO.construirDTO(resposta.getAluno()))
                .build();
    }

}
