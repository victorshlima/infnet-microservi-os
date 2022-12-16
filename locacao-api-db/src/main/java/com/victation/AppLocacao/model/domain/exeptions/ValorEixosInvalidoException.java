package com.victation.AppLocacao.model.domain.exeptions;

public class ValorEixosInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;
    public ValorEixosInvalidoException(String mensagem) {
        super(mensagem);
    }
}
