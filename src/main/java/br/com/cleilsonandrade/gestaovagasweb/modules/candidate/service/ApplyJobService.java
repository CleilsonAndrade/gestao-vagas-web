package br.com.cleilsonandrade.gestaovagasweb.modules.candidate.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApplyJobService {
  @Value("${base.url}")
  private String baseUrl;

  public String execute(String token, UUID idJob) {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();

    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(token);

    HttpEntity<UUID> request = new HttpEntity<>(idJob, headers);

    var result = restTemplate.postForObject(baseUrl + "/candidates/jobs/apply", request, String.class);

    return result;
  }
}
