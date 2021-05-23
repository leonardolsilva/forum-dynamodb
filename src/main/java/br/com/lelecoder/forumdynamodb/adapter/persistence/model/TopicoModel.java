package br.com.lelecoder.forumdynamodb.adapter.persistence.model;


import br.com.lelecoder.forumdynamodb.core.domain.SituacaoTopico;
import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@DynamoDbBean
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopicoModel {

    private String identificadorTopico;
    private String titulo;
    private String mensagem;
    private LocalDateTime dataCriacao;
    private SituacaoTopico status;
    private AlunoModel autor;
    private DisciplinaModel disciplina;
    private List<RespostaModel> respostas;

    @DynamoDbAttribute("id_topico")
    @DynamoDbPartitionKey
    public String getIdentificadorTopico() {
        return identificadorTopico;
    }

    @DynamoDbAttribute("titulo")
    public String getTitulo() {
        return titulo;
    }

    @DynamoDbAttribute("mensagem")
    public String getMensagem() {
        return mensagem;
    }

    @DynamoDbAttribute("data_criacao")
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    @DynamoDbAttribute("situacao")
    @DynamoDbSortKey
    public SituacaoTopico getStatus() {
        return status;
    }

    @DynamoDbAttribute("autor")
    public AlunoModel getAutor() {
        return autor;
    }

    @DynamoDbAttribute("disciplina")
    public DisciplinaModel getDisciplina() {
        return disciplina;
    }

    @DynamoDbAttribute("respostas")
    public List<RespostaModel> getRespostas() {
        return respostas;
    }
}
