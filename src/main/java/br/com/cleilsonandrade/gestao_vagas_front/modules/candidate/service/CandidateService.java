package br.com.cleilsonandrade.gestao_vagas_front.modules.candidate.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cleilsonandrade.gestao_vagas_front.modules.candidate.dto.TokenDto;

@Service
public class CandidateService {
  public TokenDto login(String username, String password) {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();

    headers.setContentType(MediaType.APPLICATION_JSON);

    Map<String, String> data = new HashMap<>();
    data.put("username", username);
    data.put("password", password);

    HttpEntity<Map<String, String>> request = new HttpEntity<>(data, headers);

    var result = restTemplate.postForObject("http://localhost:8080/candidates/auth", request, TokenDto.class);

    return result;
  }
}
