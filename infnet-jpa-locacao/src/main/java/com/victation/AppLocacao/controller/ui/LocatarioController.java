package com.victation.AppLocacao.controller.ui;

import com.victation.AppLocacao.model.domain.Locatario;
import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.service.LocatarioService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LocatarioController {

    private final LocatarioService locatarioService;
    private String mensagem;
    private String tipo;

    public LocatarioController(LocatarioService locatarioService) {
        this.locatarioService = locatarioService;
    }

    @GetMapping(value = "/locatario" )
    public String telaCadastro(@NotNull Model model, @SessionAttribute("user") Usuario user) {
        model.addAttribute("user", user);
        return "locatario/cadastro";
    }

    @GetMapping("/locatario/lista")
    public String telaLista(HttpServletRequest request, Model model, @SessionAttribute("user") Usuario usuario) {
        model.addAttribute("listagem", locatarioService.obterLista(usuario));
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("tipo", tipo);
        model.addAttribute("user", usuario);
        return "/locatario/lista";
    }

    @PostMapping(value = "/locatario/incluir")
    public String incluir(Locatario locatario, @SessionAttribute("user") Usuario usuario) {
        locatario.setUsuario(usuario);
        locatarioService.incluir(locatario);
        mensagem = "Inclusão realizada com sucesso: " + locatario.getNome();
        tipo = "sucess";
        return "redirect:/locatario/lista";
    }

    @GetMapping(value = "/locatario/{id}/excluir")
    public String excluir(@PathVariable Integer id) {
        try {
            locatarioService.excluir(id);
            mensagem = "Exclusão realizada com sucesso: " + id;
        } catch (Exception e) {
            mensagem = "Impossível excluir" + id;
            tipo = "danger";;
        }
        return "redirect:/locatario/lista";
    }

}
