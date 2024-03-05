package br.com.cleilsonandrade.gestao_vagas_front.modules.candidate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cleilsonandrade.gestao_vagas_front.modules.candidate.service.CandidateService;
import br.com.cleilsonandrade.gestao_vagas_front.modules.candidate.service.ProfileCandidateService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/candidates")
public class CandidateController {
  @Autowired
  private CandidateService candidateService;

  @Autowired
  private ProfileCandidateService profileCandidateService;

  @GetMapping("/login")
  public String login() {
    return "candidate/login";
  }

  @PostMapping("/signIn")
  public String signIn(RedirectAttributes redirectAttributes, HttpSession session, String username, String password) {
    try {
      var token = candidateService.login(username, password);
      var grants = token.getRoles().stream()
          .map(role -> new SimpleGrantedAuthority("ROLE_" + role.toString().toUpperCase())).toList();

      UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(null, null, grants);
      auth.setDetails(token.getAccess_token());

      SecurityContextHolder.getContext().setAuthentication(auth);
      SecurityContext securityContext = SecurityContextHolder.getContext();
      session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
      session.setAttribute("token", token);

      return "redirect:candidate/profile";
    } catch (HttpClientErrorException e) {
      redirectAttributes.addAttribute("error_message", "Usuário/Senha incorreto(s)");
      return "redirect:/candidate/login";
    }
  }

  @GetMapping("/profile")
  @PreAuthorize("hasRole('CANDIDATE')")
  public String profile() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    var result = profileCandidateService.execute(authentication.getDetails().toString());

    return "candidate/profile";
  }

}
