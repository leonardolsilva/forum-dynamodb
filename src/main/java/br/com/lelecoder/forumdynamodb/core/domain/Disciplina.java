package br.com.lelecoder.forumdynamodb.core.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Disciplina {

    private final String identificadorDisciplina;
    private final String nome;
    private final String categoria;
}
