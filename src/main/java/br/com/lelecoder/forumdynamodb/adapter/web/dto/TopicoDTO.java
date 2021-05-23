package br.com.lelecoder.forumdynamodb.adapter.web.dto;

import br.com.lelecoder.forumdynamodb.core.domain.SituacaoTopico;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TopicoDTO {

    @JsonProperty("id_topico")
    private String identificadorTopico;

    @JsonProperty("titulo")
    private String titulo;

    @JsonProperty("mensagem")
    private String mensagem;

    @JsonProperty("data_criacao")
    private LocalDateTime dataCriacao;

    @JsonProperty("status")
    private SituacaoTopico status;

    @JsonProperty("autor")
    private AlunoDTO autor;

    @JsonProperty("disciplina")
    private DisciplinaDTO disciplina;
}
