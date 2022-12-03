package com.victation.AppLocacao.model.domain;

import com.victation.AppLocacao.interfaces.IPrinter;
import com.victation.AppLocacao.model.domain.exeptions.ValorMotoInvalidoException;

import javax.persistence.*;

@Entity
@Table
public class Moto extends Automovel implements IPrinter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int peso;
    private String  tipoRoda;
    private float valor;

    public Moto(int peso, String tipoRoda) {
        this.peso = peso;
        this.tipoRoda = tipoRoda;
    }

    public Moto() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getTipoRoda() {
        return tipoRoda;
    }

    public void setTipoRoda(String tipoRoda) {
        this.tipoRoda = tipoRoda;
    }


    @Override
    public float calcularValorLocacao() throws ValorMotoInvalidoException {

        if(valor < 5000L){
            throw new ValorMotoInvalidoException("valor: " +valor+ " menor que 5000, valor invalida");
        }

        return  getModelo().equals("BMW") ?  valor * 4.5f  :  valor * 1.5f;
    };

    @Override
    public void impressao() {
        System.out.println("#Moto");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Moto{" +
                "peso:" + peso +
                "tipoRoda" + tipoRoda +
                ":" + super.toString() +
                '}';
    }


}
