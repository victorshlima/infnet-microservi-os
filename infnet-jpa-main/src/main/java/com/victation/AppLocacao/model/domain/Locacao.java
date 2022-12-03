package com.victation.AppLocacao.model.domain;

import com.victation.AppLocacao.interfaces.IPrinter;
import com.victation.AppLocacao.model.domain.exeptions.AutomovelNullExecption;
import com.victation.AppLocacao.model.domain.exeptions.LocatarioNullExecption;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table
public class Locacao   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descricao;
    private LocalDateTime dataLocacao;
    private LocalDateTime dataDevolucao;
    private boolean web;
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "idLocatario")
    private Locatario locatario;
    @ManyToMany(cascade = CascadeType.DETACH)//para cadastrar uma locação é necessário um produto existente
    private List<Automovel> automoveis = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;


    public Locacao(Locatario locatario, List<Automovel> automoveis) throws LocatarioNullExecption, AutomovelNullExecption {

        if(locatario == null){
            throw new LocatarioNullExecption("Solicitante não pode ser nulo");
        }
//
//        if(automoveis.isEmpty()){
//            throw new AutomovelNullExecption("Objeto Nulo, necessario associar um objeto automóvel na locação");
//        }
//
//        if(automoveis.isEmpty()){
//            throw new AutomovelNullExecption("Nõa pode fazer uma solicitação sem Automoveis");
//        }

        this.dataLocacao = LocalDateTime.now();
        this.locatario = locatario;
        this.automoveis =automoveis;
    }

    public Locacao() {

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

    public LocalDateTime getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDateTime dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public List<Automovel> getAutomoveis() {
        return automoveis;
    }

    public void setAutomovel(Automovel automovel) {
        this.automoveis.add(automovel);
    }

    public void setAutomoveis(List<Automovel> automoveis) {
        this.automoveis= automoveis;
    }

    public boolean isWeb() {
        return web;
    }

    public void setWeb(boolean web) {
        this.web = web;
    }

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }




    @Override
    public String toString() {
        return "\nLocacao{" +
                "descricao='" + descricao + '\'' +
                ", dataLocacao=" + dataLocacao +
                ", dataDevolucao=" + dataDevolucao +
                ", web=" + web +
                ", locatario=" + locatario +
                ", automoveis=" + automoveis +
                '}';
    }

    public Locacao(Integer id, String descricao, LocalDateTime dataLocacao, LocalDateTime dataDevolucao, boolean web, Locatario locatario, List<Automovel> automoveis) {
        this.id = id;
        this.descricao = descricao;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.web = web;
        this.locatario = locatario;
        this.automoveis = automoveis;
    }



}
