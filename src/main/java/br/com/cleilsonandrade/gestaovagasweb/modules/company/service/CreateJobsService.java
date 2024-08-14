package br.com.cleilsonandrade.gestaovagasweb.modules.company.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cleilsonandrade.gestaovagasweb.modules.company.dto.CreateJobsDTO;

@Service
public class CreateJobsService {
  @Value("${base.url}")
  private String baseUrl;

  public String execute(CreateJobsDTO jobs, String token) {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();

    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(token);

    HttpEntity<CreateJobsDTO> request = new HttpEntity<>(jobs, headers);

    var result = restTemplate.postForObject(baseUrl + "/companies/jobs/", request, String.class);

    return result;
  }
}
