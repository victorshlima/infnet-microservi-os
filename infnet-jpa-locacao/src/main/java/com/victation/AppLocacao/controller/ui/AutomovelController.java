package com.victation.AppLocacao.controller.ui;

import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.service.AutomovelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class AutomovelController {

    private final AutomovelService automovelService;
    private String mensagem;
    private String tipo;

    public AutomovelController(AutomovelService automovelService) {
        this.automovelService = automovelService;
    }

    @GetMapping("/automovel/lista")
    public String telaLista ( Model model, @SessionAttribute("user") Usuario user){
        model.addAttribute("listagem", automovelService.obterLista(user));
        model.addAttribute("user", user);
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("tipo", tipo);
        return "/automovel/lista";
    }

    @GetMapping("/automovel/{id}/excluir")
    public String excluir(@PathVariable Integer id){
        try {
            automovelService.excluir(id);
            mensagem = "Exclusão realizada com sucesso: " + id;
        } catch (Exception e) {
            mensagem = "Impossível excluir usuário:" + id;
            tipo = "danger";
        }

        return "redirect:/automovel/lista";
    }



}
