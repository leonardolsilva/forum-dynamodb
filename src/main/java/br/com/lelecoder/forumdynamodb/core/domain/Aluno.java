package br.com.lelecoder.forumdynamodb.core.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Aluno {

    private final String identificadorAluno;
    private final String nome;
    private final String email;
    private final int idade;

}
