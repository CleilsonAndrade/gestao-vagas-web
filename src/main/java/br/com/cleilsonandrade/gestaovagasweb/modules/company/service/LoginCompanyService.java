package br.com.cleilsonandrade.gestaovagasweb.modules.company.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cleilsonandrade.gestaovagasweb.modules.candidate.dto.TokenDto;

@Service
public class LoginCompanyService {
  @Value("${base.url}")
  private String baseUrl;

  public TokenDto execute(String username, String password) {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();

    headers.setContentType(MediaType.APPLICATION_JSON);

    Map<String, String> data = new HashMap<>();
    data.put("username", username);
    data.put("password", password);

    HttpEntity<Map<String, String>> request = new HttpEntity<>(data, headers);

    var result = restTemplate.postForObject(baseUrl + "/companies/auth/", request, TokenDto.class);

    return result;
  }
}
