package com.victation.AppLocacao.model.domain.exeptions;

public class ValorMotoInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public ValorMotoInvalidoException(String mensagem) {
        super(mensagem);
    }
}
