package com.victation.AppLocacao.controller.ui;

import com.victation.AppLocacao.model.domain.Locacao;
import com.victation.AppLocacao.model.domain.Usuario;
import com.victation.AppLocacao.model.test.AppImpressao;
import com.victation.AppLocacao.service.AutomovelService;
import com.victation.AppLocacao.service.LocacaoService;
import com.victation.AppLocacao.service.LocatarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class LocacaoController {

    private static Integer id =1;

    private final LocacaoService locacaoService;
    private final LocatarioService locatarioService;
    private final AutomovelService automovelService;
    private String mensagem;
    private String tipo;

    public LocacaoController(LocacaoService locacaoService, LocatarioService locatarioService, AutomovelService automovelService) {
        this.locacaoService = locacaoService;
        this.locatarioService = locatarioService;
        this.automovelService = automovelService;
    }

    @PostMapping("/locacao/incluir")
    public String incluir(Locacao locacao, @SessionAttribute("user") Usuario user){
        locacao.setUsuario(user);
        locacaoService.incluir(locacao);
        mensagem = "Inclusão realizada com sucesso: " + locacao;
        tipo = "sucess";
//        for (Automovel automovel : locacao.getAutomoveis()){
//            System.out.println(automovel.getMarca());
//        }
        AppImpressao.relatorio("\n Locacao " + locacao.getDescricao() + " incuido com sucesso", locacao  );
        return "redirect:/locacao/lista";
    }

    @GetMapping("/locacao")
    public String telaCadastro ( Model model, @SessionAttribute("user") Usuario user){
        model.addAttribute("locatarios", locatarioService.obterLista());
        model.addAttribute("automoveis", automovelService.obterLista());
        model.addAttribute("user", user);
        return "locacao/cadastro";
    }

    @GetMapping("/locacao/lista")
    public String telaLista (Model model, @SessionAttribute("user") Usuario user){
        model.addAttribute("locatarios", locatarioService.obterLista());
        model.addAttribute("locacaoLista", locacaoService.obterLista(user));
        model.addAttribute("automoveis", automovelService.obterLista());
        model.addAttribute("mensagem", mensagem);
        model.addAttribute("user", user);
        model.addAttribute("tipo", tipo);
        return "/locacao/lista";
    }

    @GetMapping("/locacao/{id}/excluir")
    public String excluir(@PathVariable Integer id){
        try {
            locacaoService.excluir(id);
            mensagem = "Exclusão realizada com sucesso: " + id;
        } catch (Exception e) {
            mensagem = "Impossível excluir" + id;
            tipo = "danger";;
        }
        return "redirect:/locacao/lista";
    }


}
