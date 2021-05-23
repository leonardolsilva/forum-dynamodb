package br.com.lelecoder.forumdynamodb.core.exceptions;

public class TopicoNaoEncontradoException extends RuntimeException {

    public TopicoNaoEncontradoException(String message) {
        super(message);
    }
}
