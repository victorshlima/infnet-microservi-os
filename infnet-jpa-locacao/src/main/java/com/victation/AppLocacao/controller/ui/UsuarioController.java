package com.victation.AppLocacao.controller.ui;

import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UsuarioController {

    private final UsuarioService usuarioService;
    private String mensagem;
    private String tipo;
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuario/lista")
    public String telaLista (HttpServletRequest request, Model model, @SessionAttribute("user") Usuario user){
        model.addAttribute("usuarioLista", usuarioService.obterLista());
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("tipo", tipo);
        model.addAttribute("user", user);
        return "/usuario/lista";
    }

    @PostMapping("/usuario/incluir")
    public String incluir(Usuario usuario){
        System.out.println("Cadastro !!!   " + usuario.getNome());

        usuarioService.incluir(usuario);
       // AppImpressao.relatorio("usuario " + usuario.getNome() + " incuido com sucesso", usuario);
        mensagem = "Inclusão realizada com sucesso: " + usuario;
        tipo = "sucess";
        return "redirect:/";
    }

    @GetMapping("/usuario")
    public String telaCadastro ( ){

        return "usuario/cadastro";

    }

    @GetMapping("/usuario/{id}/excluir")
    public String excluir(@PathVariable Integer id){
        try {
            usuarioService.excluir(id);
            mensagem = "Exclusão realizada com sucesso: " + id;
        } catch (Exception e) {
            mensagem = "Impossível excluir" + id;
            tipo = "danger";;
        }
        return "redirect:/usuario/lista";
    }


}
