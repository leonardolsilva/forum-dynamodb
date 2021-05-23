package br.com.lelecoder.forumdynamodb.adapter.persistence.mapper;

import br.com.lelecoder.forumdynamodb.adapter.persistence.model.TopicoModel;
import br.com.lelecoder.forumdynamodb.core.domain.Topico;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TopicoMapper {

    private static final AlunoMapper mapperAluno = new AlunoMapper();
    private static final DisciplinaMapper mapperDisciplina = new DisciplinaMapper();
    private static final RespostaMapper mapperResposta = new RespostaMapper();

    public Topico paraDominio(TopicoModel model) {
        return Optional.ofNullable(model)
                .map(topicoModel -> new Topico(
                        model.getIdentificadorTopico(),
                        model.getTitulo(),
                        model.getMensagem(),
                        model.getDataCriacao(),
                        model.getStatus(),
                        mapperAluno.paraDominio(model.getAutor()),
                        mapperDisciplina.paraDominio(model.getDisciplina()),
                        mapperResposta.paraDominio(model.getRespostas())))
                .orElse(Topico.builder().build());
    }

    public TopicoModel paraModel(Topico topico) {
        return TopicoModel
                .builder()
                .identificadorTopico(topico.getIdentificadorTopico())
                .titulo(topico.getTitulo())
                .mensagem(topico.getMensagem())
                .dataCriacao(topico.getDataCriacao())
                .status(topico.getStatus())
                .autor(mapperAluno.paraModel(topico.getAutor()))
                .disciplina(mapperDisciplina.paraModel(topico.getDisciplina()))
                .respostas(mapperResposta.paraModel(topico.getRespostas()))
                .build();
    }
}
