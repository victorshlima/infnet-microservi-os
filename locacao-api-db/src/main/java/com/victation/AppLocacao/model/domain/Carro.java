package com.victation.AppLocacao.model.domain;

import com.victation.AppLocacao.interfaces.IPrinter;
import com.victation.AppLocacao.model.domain.exeptions.QuantidadePortasCarroInvalidoException;

import javax.persistence.*;

@Entity
@Table
public class Carro extends Automovel implements IPrinter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public int portas;
    private float valor;


    public Carro(String marca, String modelo, int portas) {
        super();
        super.marca = marca;
        super.modelo = modelo;
        this.portas = portas;
    }

    public Carro(Integer id, String marca, String modelo, int portas) {
        super();
        this.id = id;
        super.marca = marca;
        super.modelo = modelo;
        this.portas = portas;
    }

    public Carro() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public float calcularValorLocacao() throws QuantidadePortasCarroInvalidoException {
        if (portas > 4) {
            throw new QuantidadePortasCarroInvalidoException("portas: " + portas + " Maior que 4, Quantidade por portas invalida");
        }

        return getPortas() > 2 ? valor * 3.5f : valor * 2.5f;
    }

    @Override
    public String toString() {
        return "\nCarro{" +
                "portas=" + portas +
                ";" + super.toString() +
                '}';
    }

    @Override
    public void impressao() {
        System.out.println("#Carro");
        System.out.println(this);
    }

    public int getPortas() {
        return portas;
    }
    public void setPortas(int portas) {
        this.portas = portas;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
