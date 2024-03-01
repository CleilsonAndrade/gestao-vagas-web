package br.com.cleilsonandrade.gestao_vagas_front.modules.candidate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/candidates")
public class CandidateController {

  @GetMapping("/login")
  public String login() {
    return "candidate/login";
  }

}
