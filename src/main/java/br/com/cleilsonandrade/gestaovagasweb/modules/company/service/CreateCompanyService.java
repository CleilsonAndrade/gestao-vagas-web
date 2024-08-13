package br.com.cleilsonandrade.gestaovagasweb.modules.company.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.cleilsonandrade.gestaovagasweb.modules.company.dto.CreateCompanyDTO;

@Service
public class CreateCompanyService {
  @Value("${base.url}")
  private String baseUrl;

  public String execute(CreateCompanyDTO createCompanyDTO) {
    RestTemplate restTemplate = new RestTemplate();

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<CreateCompanyDTO> request = new HttpEntity<>(createCompanyDTO, headers);
    return restTemplate.postForObject(baseUrl + "/companys/create", request, String.class);
  }
}
