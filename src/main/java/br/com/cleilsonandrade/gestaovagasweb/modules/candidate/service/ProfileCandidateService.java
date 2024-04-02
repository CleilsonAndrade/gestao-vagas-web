package br.com.cleilsonandrade.gestaovagasweb.modules.candidate.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProfileCandidateService {
  @Value("${base.url}")
  private String baseUrl;

  public String execute(String token) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(token);

    HttpEntity<Map<String, String>> request = new HttpEntity<>(headers);

    var result = restTemplate.exchange(baseUrl + "/candidates", HttpMethod.GET, request,
        String.class);
    return result.getBody();
  }
}
