package br.com.lelecoder.forumdynamodb.core.ports.in;

import br.com.lelecoder.forumdynamodb.core.domain.Resposta;

public interface BuscarRespostaSolucionadora {
    Resposta encontrar(String idTopico);
}
