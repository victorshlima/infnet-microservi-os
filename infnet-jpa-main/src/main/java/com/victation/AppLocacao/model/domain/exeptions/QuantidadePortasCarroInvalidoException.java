package com.victation.AppLocacao.model.domain.exeptions;

public class QuantidadePortasCarroInvalidoException extends Exception {

    private static final long serialVersionUID = 1L;

    public QuantidadePortasCarroInvalidoException(String message) {
        super(message);
    }
}
