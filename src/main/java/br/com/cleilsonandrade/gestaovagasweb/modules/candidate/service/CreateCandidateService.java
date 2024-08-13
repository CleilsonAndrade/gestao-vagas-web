package br.com.cleilsonandrade.gestaovagasweb.modules.candidate.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cleilsonandrade.gestaovagasweb.modules.candidate.dto.CreateCandidateDTO;

@Service
public class CreateCandidateService {
  @Value("${base.url}")
  private String baseUrl;

  public void execute(CreateCandidateDTO createCandidateDTO) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<CreateCandidateDTO> request = new HttpEntity<>(createCandidateDTO, headers);

    restTemplate.postForObject(baseUrl + "/candidates/create", request, String.class);

  }
}
