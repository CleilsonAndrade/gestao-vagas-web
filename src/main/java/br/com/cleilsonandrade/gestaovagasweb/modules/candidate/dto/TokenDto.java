package br.com.cleilsonandrade.gestaovagasweb.modules.candidate.dto;

import java.util.List;

public class TokenDto {
  private String access_token;
  private List<String> roles;
  private Long expires_in;

  public Long getExpires_in() {
    return expires_in;
  }

  public void setExpires_in(Long expires_in) {
    this.expires_in = expires_in;
  }

  public List<String> getRoles() {
    return roles;
  }

  public void setRoles(List<String> roles) {
    this.roles = roles;
  }

  public String getAccess_token() {
    return access_token;
  }

  public void setAccess_token(String access_token) {
    this.access_token = access_token;
  }

}
