package br.com.lelecoder.forumdynamodb.adapter.persistence.mapper;

import br.com.lelecoder.forumdynamodb.adapter.persistence.model.AlunoModel;
import br.com.lelecoder.forumdynamodb.core.domain.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    public Aluno paraDominio(AlunoModel model) {
        return new Aluno(
                model.getIdentificadorAluno(),
                model.getNome(),
                model.getEmail(),
                model.getIdade()
        );
    }

    public AlunoModel paraModel(Aluno aluno) {
        return AlunoModel
                .builder()
                .identificadorAluno(aluno.getIdentificadorAluno())
                .nome(aluno.getNome())
                .email(aluno.getEmail())
                .idade(aluno.getIdade())
                .build();
    }
}
