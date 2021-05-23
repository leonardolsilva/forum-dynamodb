package br.com.lelecoder.forumdynamodb.adapter.persistence.mapper;

import br.com.lelecoder.forumdynamodb.adapter.persistence.model.RespostaModel;
import br.com.lelecoder.forumdynamodb.core.domain.Resposta;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RespostaMapper {

    private static final AlunoMapper mapperAluno = new AlunoMapper();

    public List<Resposta> paraDominio(List<RespostaModel> models) {
        return models
                .stream()
                .map(this::paraDominio)
                .collect(Collectors.toList());
    }

    public List<RespostaModel> paraModel(List<Resposta> respostas) {
        return respostas
                .stream()
                .map(this::paraModel)
                .collect(Collectors.toList());
    }

    private Resposta paraDominio(RespostaModel model) {
        return new Resposta(
                model.getIdentificadorResposta(),
                model.getTexto(),
                LocalDateTime.parse(model.getDataCriacao()),
                mapperAluno.paraDominio(model.getAluno())
        );
    }

    private RespostaModel paraModel(Resposta resposta) {
        return RespostaModel
                .builder()
                .identificadorResposta(resposta.getIdentificadorResposta())
                .texto(resposta.getTexto())
                .dataCriacao(resposta.getDataCriacao().toString())
                .aluno(mapperAluno.paraModel(resposta.getAluno()))
                .build();
    }
}
