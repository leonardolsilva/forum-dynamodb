package br.com.lelecoder.forumdynamodb.adapter.web.dto;

import br.com.lelecoder.forumdynamodb.core.domain.Aluno;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AlunoDTO {

    private String nome;
    private String email;

    public static AlunoDTO construirDTO(Aluno aluno) {
        return AlunoDTO
                .builder()
                .nome(aluno.getNome())
                .email(aluno.getEmail())
                .build();
    }
}
