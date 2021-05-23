package br.com.lelecoder.forumdynamodb.adapter.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@Data
@DynamoDbBean
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoModel {

    private String identificadorAluno;
    private String nome;
    private String email;
    private Integer idade;

    @DynamoDbAttribute("id_aluno")
    public String getIdentificadorAluno() {
        return identificadorAluno;
    }

    @DynamoDbAttribute("nome")
    public String getNome() {
        return nome;
    }

    @DynamoDbAttribute("email")
    public String getEmail() {
        return email;
    }

    @DynamoDbAttribute("idade")
    public Integer getIdade() {
        return idade;
    }
}
