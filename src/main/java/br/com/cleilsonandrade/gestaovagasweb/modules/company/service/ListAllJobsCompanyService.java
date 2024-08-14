package br.com.cleilsonandrade.gestaovagasweb.modules.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cleilsonandrade.gestaovagasweb.modules.candidate.dto.JobDTO;

@Service
public class ListAllJobsCompanyService {
  @Value("${base.url}")
  private String baseUrl;

  public List<JobDTO> execute(String token) {
    RestTemplate restTemplate = new RestTemplate();
    HttpHeaders headers = new HttpHeaders();
    headers.setBearerAuth(token);

    HttpEntity<Object> httpEntity = new HttpEntity<>(headers);

    ParameterizedTypeReference<List<JobDTO>> responseType = new ParameterizedTypeReference<List<JobDTO>>() {
    };

    var result = restTemplate.exchange(baseUrl + "/companies/jobs/", HttpMethod.GET, httpEntity, responseType);

    return result.getBody();
  }
}
