package br.com.lelecoder.forumdynamodb.adapter.persistence.model;

import br.com.lelecoder.forumdynamodb.adapter.persistence.converters.AlunoModelConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;

@Data
@DynamoDbBean
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RespostaModel {

    private String identificadorResposta;
    private String texto;
    private String dataCriacao;
    private AlunoModel aluno;
    private Boolean solucao;

    @DynamoDbAttribute("id_resposta")
    public String getIdentificadorResposta() {
        return identificadorResposta;
    }

    @DynamoDbAttribute("texto")
    public String getTexto() {
        return texto;
    }

    @DynamoDbAttribute("data_criacao")
    public String getDataCriacao() {
        return dataCriacao;
    }

    @DynamoDbAttribute("aluno")
    @DynamoDbConvertedBy(AlunoModelConverter.class)
    public AlunoModel getAluno() {
        return aluno;
    }

    @DynamoDbAttribute("solucao")
    public Boolean isSolucao() {
        return solucao;
    }
}
