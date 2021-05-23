package br.com.lelecoder.forumdynamodb.adapter.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RespostaDTO {

    @JsonProperty("topico")
    private TopicoDTO topico;

    @JsonProperty("resposta_solucionadora")
    public String texto;

}
