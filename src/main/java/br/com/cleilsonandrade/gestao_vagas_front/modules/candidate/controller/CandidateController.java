package br.com.cleilsonandrade.gestao_vagas_front.modules.candidate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

  @GetMapping("/login")
  public String login() {
    return "candidate/login";
  }

  @PostMapping("/signIn")
  public String signIn(RedirectAttributes redirectAttributes, String username, String password) {

    redirectAttributes.addAttribute("error_message", "Usuário/Senha incorreto(s)");
    return "redirect:/candidate/login";
  }

}
