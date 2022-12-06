package com.victation.AppLocacao.controller.ui;

import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.service.AppService;
import com.victation.AppLocacao.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes("user")
@Controller
public class AppLocacaoController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AppService appService;

    @GetMapping("/")
    public String getHome (Model model){
        model.addAttribute("projeto",appService.obterProjeto());
        return "home";
    }

    @GetMapping("/login")
    public String getTelaLogin ( ){
        return "/login";
    }

    @PostMapping("/login")
    public String getLogin (Model model, @RequestParam String email, @RequestParam  String senha ){
        Usuario usuario = usuarioService.validar(email,senha);
        System.out.println("tentativa login" + email+senha  );
        if( usuario != null){
            System.out.println("localizado login" + usuario.getEmail());
            model.addAttribute("user", usuario);
            return "redirect:/";
        }
        return "login";
        //return "redirect:/login";
    }

    @GetMapping("/usuario/cadastro")
    public String getSignUp (){
        return "/usuario/cadastro";
    }

    @GetMapping(value = "/logout")
    public String logout(HttpSession session, SessionStatus status) {
        status.setComplete();
        session.removeAttribute("user");
        return "redirect:/";
    }

}
