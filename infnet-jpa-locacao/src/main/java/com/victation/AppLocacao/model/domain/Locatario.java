package com.victation.AppLocacao.model.domain;


import com.victation.AppLocacao.interfaces.IPrinter;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table
public class Locatario
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public String nome;
    public String sobrenome;
    public String cpf;
    public String email;

    @ManyToOne
    @JoinColumn(name = "idUsuario")// con join collum ele cria um relacionamento apenas por chave primaria
    // é possível fazer esse relacionamento sem @JoinClounm, desta forma criaria uma tabela de relacionamento
    public Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Locatario(Integer id, String nome, String sobrenome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
    }

    public Locatario(String nome, String sobrenome, String cpf, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
    }

    public Locatario() {

    }

//    public Locatario(Integer id, String nome, String sobrenome, String cpf, String email )
//     throws CPFInvalidoExeption {
//
//       if ( cpf == null){
//            throw new CPFInvalidoExeption("Não é possivel aceitar cpf nulo");
//        }
//
//        if ( cpf.isEmpty()){
//            throw new CPFInvalidoExeption("Não é possivel aceitar cpf nulo");
//        }
//        this.id = id;
//        this.nome = nome;
//        this.sobrenome = sobrenome;
//        this.cpf = cpf;
//        this.email = email;
//    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    @Override
    public String toString() {
        return "\nLocatario{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Locatario)) return false;
        Locatario locatario = (Locatario) o;
        return Objects.equals(id, locatario.id) && Objects.equals(nome, locatario.nome) && Objects.equals(sobrenome, locatario.sobrenome) && Objects.equals(cpf, locatario.cpf) && Objects.equals(email, locatario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, sobrenome, cpf, email);
    }
}
