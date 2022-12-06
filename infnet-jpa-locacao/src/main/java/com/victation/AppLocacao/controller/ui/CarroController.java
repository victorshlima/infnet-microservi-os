package com.victation.AppLocacao.controller.ui;

import com.victation.AppLocacao.model.domain.Carro;
import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.service.CarroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class CarroController {

    private final CarroService carroService;
    private String mensagem;
    private String tipo;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping(value = "/carro")
    public String telaCadastro( Model model, @SessionAttribute("user") Usuario user){
        model.addAttribute("user", user);
        return "carro/cadastro";
    }

    @GetMapping("/carro/lista")
    public String telaLista (Model model, @SessionAttribute("user") Usuario user){
        model.addAttribute("listagem", carroService.obterLista(user));
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("tipo", tipo);
        model.addAttribute("user", user);
        return "/carro/lista";
    }

    @GetMapping("/carro/{id}/excluir")
    public String excluir(@PathVariable Integer id){
        try {
            carroService.excluir(id);
            mensagem = "Exclusão realizada com sucesso: " + id;
        } catch (Exception e) {
            mensagem = "Impossível excluir" + id;
            tipo = "danger";;
        }
        return "redirect:/carro/lista";
    }
    @PostMapping(value ="/carro/incluir" )
    public String incluir(Carro carro, @SessionAttribute("user")Usuario user){
        carroService.incluir(carro, user);
        mensagem = "Inclusão realizada com sucesso: " + carro;
        tipo = "sucess";

        return  "redirect:/carro/lista";
    }

}
