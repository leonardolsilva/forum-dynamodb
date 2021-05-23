package br.com.lelecoder.forumdynamodb.core.ports.out;

import br.com.lelecoder.forumdynamodb.core.domain.Topico;

import java.util.Optional;

public interface TopicoPort {

    Optional<Topico> buscar(String idTopico);
}
