package br.com.cleilsonandrade.gestaovagasweb.modules.company.dto;

import lombok.Data;

@Data
public class CreateCompanyDTO {
  private String username;
  private String password;
  private String email;
  private String website;
  private String description;
  private String name;
}
