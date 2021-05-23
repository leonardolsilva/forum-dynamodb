package br.com.lelecoder.forumdynamodb.adapter.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ErrorMessage {

    private final String mensagem;

    @JsonProperty("status_code")
    private final int statusCode;

    public ErrorMessage(String mensagem, int statusCode) {
        this.mensagem = mensagem;
        this.statusCode = statusCode;
    }

}
