package br.com.lelecoder.forumdynamodb.adapter.persistence.mapper;

import br.com.lelecoder.forumdynamodb.adapter.persistence.model.DisciplinaModel;
import br.com.lelecoder.forumdynamodb.core.domain.Disciplina;
import org.springframework.stereotype.Component;

@Component
public class DisciplinaMapper {

    public Disciplina paraDominio(DisciplinaModel model) {
        return new Disciplina(
                model.getIdentificadorDisciplina(),
                model.getNome(),
                model.getCategoria()
        );
    }

    public DisciplinaModel paraModel(Disciplina disciplina) {
        return DisciplinaModel
                .builder()
                .identificadorDisciplina(disciplina.getIdentificadorDisciplina())
                .nome(disciplina.getNome())
                .categoria(disciplina.getCategoria())
                .build();
    }
}
