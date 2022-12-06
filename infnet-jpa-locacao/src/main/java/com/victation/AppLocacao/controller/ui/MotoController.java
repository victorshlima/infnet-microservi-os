package com.victation.AppLocacao.controller.ui;


import com.victation.AppLocacao.model.domain.Moto;
import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;



@Controller
public class MotoController {

    @Autowired
    private MotoService motoService;
    private String mensagem;
    private String tipo;

    @GetMapping(value = "/moto")
    public String telaCadastro(Model model, @SessionAttribute("user") Usuario user){
        model.addAttribute("user", user);
        return "moto/cadastro";
    }

    @GetMapping("/moto/lista")
    public String telaLista (Model model, @SessionAttribute("user") Usuario user){
        model.addAttribute("listagem", motoService.obterLista(user));
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("tipo", tipo);
        model.addAttribute("user", user);
        return "/moto/lista";
    }

    @PostMapping(value ="/moto/incluir" )
    public String incluir(Moto moto, @SessionAttribute("user")Usuario user){
        motoService.incluir(moto, user);
        mensagem = "Inclusão realizada com sucesso: " + moto;
        tipo = "sucess";
        return  "redirect:/moto/lista";
    }

    @GetMapping(value ="/moto/{id}/excluir" )
    public String excluir(@PathVariable Integer id ){
        try {
            motoService.excluir(id);
            mensagem = "Exclusão realizada com sucesso: " + id;
        } catch (Exception e) {
            mensagem = "Impossível excluir" + id;
            tipo = "danger";;
        }
        return  "redirect:/moto/lista";
    }

}
