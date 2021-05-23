package br.com.lelecoder.forumdynamodb.adapter.web;

import br.com.lelecoder.forumdynamodb.adapter.web.dto.RespostaDTO;
import br.com.lelecoder.forumdynamodb.core.domain.Resposta;
import br.com.lelecoder.forumdynamodb.core.ports.in.BuscarRespostaSolucionadora;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respostas")
public class RespostaController {

    private final BuscarRespostaSolucionadora buscarRespostaSolucionadora;

    public RespostaController(BuscarRespostaSolucionadora buscarRespostaSolucionadora) {
        this.buscarRespostaSolucionadora = buscarRespostaSolucionadora;
    }

    @GetMapping(value = "/resposta_solucionadora", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RespostaDTO> buscarRespostaSolucionadora(
            @RequestParam("id_topico") String idTopico
    ) {

        Resposta resposta = buscarRespostaSolucionadora.encontrar(idTopico);

        RespostaDTO respostaDTO = RespostaDTO.construirDTO(resposta);

        return new ResponseEntity<>(respostaDTO, HttpStatus.OK);

    }
}
