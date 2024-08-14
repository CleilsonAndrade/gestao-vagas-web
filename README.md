<div align="center">
  <h1>Gestão Vagas Web</h1>
  <p>Gestão Vagas Web é o cliente web da API: Gestão Vagas API. Com o fim de gerenciamento para cadastramento de empresa e suas vagas de emprego e candidatos para o preenchimento das mesmas. Desenvolvido usando as tecnologias Java e o framework Spring e Thymeleaf.</p>
  <img src="./design/desktop.png" alt="Logo" width="800">
</div>

# 📒 Índice
* [Descrição](#descrição)
* [Requisitos Funcionais](#requisitos)
  * [Features](#features)
* [Tecnologias](#tecnologias)
* [Design](#design)
  * [Cores](#cores)
  * [Fontes](#fontes)
* [Instalação](#instalação)
* [Licença](#licença)

# 📃 <span id="descrição">Descrição</span>
Gestão Vagas Web é o cliente web da API: [**Gestão Vagas API**](https://github.com/CleilsonAndrade/gestao-vagas-api). Com o fim de gerenciamento para cadastramento de empresa e suas vagas de emprego e candidatos para o preenchimento das mesmas. Desenvolvido usando as tecnologias [**Java**](https://www.java.com/) e o framework [**Spring**](https://spring.io/) e [**Thymeleaf**](https://www.thymeleaf.org/) e autenticação usando o [**Spring Security**](https://spring.io/projects/spring-security), token [**JWT**](https://jwt.io/).

# 📌 <span id="requisitos">Requisitos Funcionais</span>
- [x] Realizar o cadastro do usuário com perfil de candidato<br>
- [x] Listar o currículo do usuário com perfil de candidato<br>
- [x] Realizar o cadastro de um usuário representando a empresa<br>
- [x] Cadastro de vaga por um usuário com perfil de empresa<br>
- [x] Listar as vagas de uma empresa com usuário representando-a<br>
- [x] Listar as vagas disponíveis para o usuário com perfil de candidato por um filtro<br>
- [x] Aplicar o usuário com perfil de candidato a uma vaga<br>

## Features
- [x] Requisição a API<br>
- [x] Responsividade<br>
- [x] Gerenciamento de sessão de usuário<br>

# 💻 <span id="tecnologias">Tecnologias</span>
- **Java**
- **Spring**
- **Spring Web**
- **Spring Boot DevTools**
- **Spring Security**
- **Thymeleaf**
- **JWT**
- **HTML**
- **CSS**
- **tailwindCSS**

# 🎨 <span id="design">Design</span>
- O modelo final para versão desktop e mobile está disponível na pasta `./design`

- <span id="cores">Cores<br></span>
  * #111827<br>
  * #FFFFFF<br>
  * #F9FAFB<br>
  * #15803D<br>

- <span id="fontes">Fontes<br></span>
  * Arial, sans-serif

# 🚀 <span id="instalação">Instalação</span>
```bash
  # Clone este repositório:
  $ git clone https://github.com/CleilsonAndrade/gestao-vagas-web.git
  $ cd ./gestao-vagas-web

  # Instalar as dependências:
  $ mvn clean install

  # Executar:
  $ mvn spring-boot:run
```

# 📝 <span id="licença">Licença</span>
Esse projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

<p align="center">
  Feito com 💜 by CleilsonAndrade
</p>
