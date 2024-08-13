package br.com.cleilsonandrade.gestaovagasweb.modules.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;

import br.com.cleilsonandrade.gestaovagasweb.modules.company.dto.CreateCompanyDTO;
import br.com.cleilsonandrade.gestaovagasweb.modules.company.service.CreateCompanyService;
import br.com.cleilsonandrade.gestaovagasweb.utils.FormatErrorMessage;

@Controller
@RequestMapping("/companys")
public class CompanyController {
  @Autowired
  CreateCompanyService createCompanyService;

  @GetMapping("/create")
  public String create(Model model) {
    model.addAttribute("company", new CreateCompanyDTO());
    return "/company/create";
  }

  @PostMapping("/create")
  public String save(Model model, CreateCompanyDTO createCompanyDTO) {
    try {
      this.createCompanyService.execute(createCompanyDTO);
      model.addAttribute("company", new CreateCompanyDTO());
    } catch (HttpClientErrorException e) {
      model.addAttribute("error_message", FormatErrorMessage.formatErroMessage(e.getResponseBodyAsString()));
      model.addAttribute("company", createCompanyDTO);
    }

    return "company/create";
  }
}
