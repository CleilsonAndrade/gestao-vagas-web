package br.com.cleilsonandrade.gestao_vagas_front.modules.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cleilsonandrade.gestao_vagas_front.modules.candidate.service.CandidateService;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
  @Autowired
  private CandidateService candidateService;

  @GetMapping("/login")
  public String login() {
    return "candidate/login";
  }

  @PostMapping("/signIn")
  public String signIn(RedirectAttributes redirectAttributes, String username, String password) {
    try {
      candidateService.login(username, password);

      return "candidate/profile";
    } catch (HttpClientErrorException e) {
      redirectAttributes.addAttribute("error_message", "Usuário/Senha incorreto(s)");
      return "redirect:/candidate/login";
    }
  }

}
