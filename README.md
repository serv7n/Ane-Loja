# AneLoja
# Sobre o Projeto

Projeto de **e-commerce** desenvolvido para uma loja, com o objetivo de oferecer aos clientes uma experiência simples e intuitiva para visualizar os produtos, comparar opções e escolher os itens que melhor atendem às suas necessidades.

Atualmente, a plataforma permite a **consulta dos produtos** e direciona o cliente para a realização da compra através do **WhatsApp**.

Como parte da evolução do projeto, estão previstas novas funcionalidades, como:

* Autenticação de usuários utilizando **Google**;
* Gerenciamento de **carrinho de compras**;
* Integração com **APIs de terceiros** especializadas em processamento de pagamentos via **PIX**;
* Geração e acompanhamento das transações diretamente pela plataforma.


## Funcionalidades

O projeto permite a integracao de imagens a cada tipo de produto e suas variacoes cor
alem disso possui dashbord feito para uma melhor praticidade do dia a dia

## Tecnologias utilizadas

Java com spring Jwt, Postgrssql, Validation, Cloudnary para envio de imagens


### Estrutura do Backend

O backend seguirá uma arquitetura de **Monólito Modular**, organizando o sistema em módulos independentes e bem definidos. Essa abordagem facilita a manutenção, a integração entre equipes e permite que determinados módulos sejam separados em serviços independentes futuramente, caso necessário.

```text
src/main/java/com/ecommerce
│
├── product/
│   ├── controller/
│   ├── service/
│   ├── repository/
│   ├── entity/
│   └── dto/
│
└── shared/
    ├── exception/
    ├── config/
    └── security/
```

Cada módulo possui suas próprias responsabilidades, mantendo **Controller, Service, Repository, Entity e DTOs** organizados dentro do respectivo domínio.

A estrutura permite que diferentes equipes trabalhem em módulos específicos com menor acoplamento, mantendo o projeto como uma única aplicação Spring Boot.

## Contribuição

O fluxo sugerido para o repositório está documentado em [`CONTRIBUTING.md`](CONTRIBUTING.md) e usa:

- Conventional Commits;
- Issue Templates;
- Pull Request Template;
- CODEOWNERS;
- GitHub Actions para CI e validação de commits.

## Estrutura do projeto

O projeto será desenvolvido com **Spring Boot**, disponibilizando uma **API REST** para comunicação com o frontend, que possivelmente será desenvolvido em **Angular**.

A estrutura dos produtos seguirá a relação:

```text
Product
 └── ProductVariant
      └── ProductImage
```

O frontend será dividido em dois painéis:

* **Painel do Cliente:** visualização dos produtos, variantes e informações, com a compra inicialmente realizada através do **WhatsApp**.
* **Painel Administrativo:** cadastro e gerenciamento de produtos, variantes, imagens, preços e demais informações da loja.

Essa estrutura mantém o frontend separado do backend e permite que a API seja utilizada por diferentes aplicações futuramente.
