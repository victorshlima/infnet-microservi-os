package com.victation.AppLocacao.controller.ui;

import com.victation.AppLocacao.model.domain.Caminhao;
import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.service.CaminhaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CaminhaoController {

    private final CaminhaoService caminhaoService;
    private String mensagem;
    private String tipo;
    public CaminhaoController(CaminhaoService caminhaoService) {
        this.caminhaoService = caminhaoService;
    }

    @GetMapping(value = "/caminhao")
    public String telaCadastro(Model model, @SessionAttribute("user") Usuario user){
        model.addAttribute("user", user);
        return "caminhao/cadastro";
    }

    @GetMapping("/caminhao/lista")
    public String telaLista (Model model, @SessionAttribute("user") Usuario user){
        model.addAttribute("listagem", caminhaoService.obterLista(user));
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("tipo", tipo);
        model.addAttribute("user", user);
        return "/caminhao/lista";
    }

    @PostMapping(value ="/caminhao/incluir" )
    public String incluir(Caminhao caminhao, @SessionAttribute("user")Usuario user){
        caminhaoService.incluir(caminhao, user);
        mensagem = "Inclusão realizada com sucesso: " + caminhao;
        tipo = "sucess";
        return  "redirect:/caminhao/lista";
    }

    @GetMapping(value = "/caminhao/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        try {
            caminhaoService.excluir(id);
            mensagem = "Exclusão realizada com sucesso: " + id;
        } catch (Exception e) {
            mensagem = "Impossível excluir:" + id;
            tipo = "danger";;
        }
        return "redirect:/caminhao/lista";
    }

}
