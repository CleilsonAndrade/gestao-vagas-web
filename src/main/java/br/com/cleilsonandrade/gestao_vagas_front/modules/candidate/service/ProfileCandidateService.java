package br.com.cleilsonandrade.gestao_vagas_front.modules.candidate.service;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProfileCandidateService {
  public String execute(String token) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(token);

    HttpEntity<Map<String, String>> request = new HttpEntity<>(headers);

    var result = restTemplate.exchange("http://localhost:8080/candidates", HttpMethod.GET, request,
        String.class);
    return result.getBody();
  }
}
