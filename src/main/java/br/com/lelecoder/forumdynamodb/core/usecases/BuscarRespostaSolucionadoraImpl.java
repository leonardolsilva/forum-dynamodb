package br.com.lelecoder.forumdynamodb.core.usecases;

import br.com.lelecoder.forumdynamodb.core.domain.Resposta;
import br.com.lelecoder.forumdynamodb.core.domain.Topico;
import br.com.lelecoder.forumdynamodb.core.exceptions.RespostaSolucionadoraNaoEncontradaException;
import br.com.lelecoder.forumdynamodb.core.exceptions.TopicoNaoEncontradoException;
import br.com.lelecoder.forumdynamodb.core.ports.in.BuscarRespostaSolucionadora;
import br.com.lelecoder.forumdynamodb.core.ports.out.TopicoPort;

import java.util.Optional;

public class BuscarRespostaSolucionadoraImpl implements BuscarRespostaSolucionadora {

    private final TopicoPort topicoPort;

    public BuscarRespostaSolucionadoraImpl(TopicoPort topicoPort) {
        this.topicoPort = topicoPort;
    }

    @Override
    public Resposta encontrar(String idTopico) {

        Optional<Topico> optionalTopico = topicoPort.buscar(idTopico);

        if (!optionalTopico.isPresent()) {
            throw new TopicoNaoEncontradoException("Não foi encontrado o tópico " + idTopico);
        }

        return optionalTopico
                .flatMap(Topico::getRespostaSolucionadora)
                .orElseThrow(() -> new RespostaSolucionadoraNaoEncontradaException("Este tópico não possui uma resposta solucionadora."));
    }
}
