package com.victation.AppLocacao.model.domain;


import com.victation.AppLocacao.interfaces.IPrinter;
import com.victation.AppLocacao.model.domain.exeptions.QuantidadePortasCarroInvalidoException;
import com.victation.AppLocacao.model.domain.exeptions.ValorEixosInvalidoException;
import com.victation.AppLocacao.model.domain.exeptions.ValorMotoInvalidoException;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table
@Inheritance(strategy = InheritanceType.JOINED) // possibilita acessar todas as tabelas que herdam...
public abstract class  Automovel    implements IPrinter { // autmovel por sere abstract não pode ser instaciada

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public String marca;
    public String modelo;
    public int cilindradas;
    public int qtdVeiculos;
    public int qtdVeiculosDisponiveis;

    @ManyToMany(mappedBy = "automoveis")
    private List<Locacao> locacoes;

    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    protected Automovel() {
    }

    public abstract float calcularValorLocacao() throws QuantidadePortasCarroInvalidoException, ValorMotoInvalidoException, ValorEixosInvalidoException;

    @Override
    public String toString() {
        return "\nAutomovel{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", cilindradas=" + cilindradas +
                '}';
    }

    public abstract void impressao();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Automovel)) return false;
        Automovel automovel = (Automovel) o;
        return cilindradas == automovel.cilindradas && qtdVeiculos == automovel.qtdVeiculos && qtdVeiculosDisponiveis == automovel.qtdVeiculosDisponiveis && Objects.equals(id, automovel.id) && Objects.equals(marca, automovel.marca) && Objects.equals(modelo, automovel.modelo) && Objects.equals(locacoes, automovel.locacoes) && Objects.equals(usuario, automovel.usuario);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, marca, modelo, cilindradas, qtdVeiculos, qtdVeiculosDisponiveis, locacoes, usuario);
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }

    public void setLocacoes(List<Locacao> locacoes) {
        this.locacoes = locacoes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public int getQtdVeiculos() {
        return qtdVeiculos;
    }

    public void setQtdVeiculos(int qtdVeiculos) {
        this.qtdVeiculos = qtdVeiculos;
    }

    public int getQtdVeiculosDisponiveis() {
        return qtdVeiculosDisponiveis;
    }

    public void setQtdVeiculosDisponiveis(int qtdVeiculosDisponiveis) {
        this.qtdVeiculosDisponiveis = qtdVeiculosDisponiveis;
    }
}
