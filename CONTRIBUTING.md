# Contributing

Obrigado por contribuir com o projeto.

## 1. Issues

Antes de implementar uma alteração, crie ou encontre uma Issue relacionada.

Use os templates disponíveis:

- `[BUG]`
- `[FEATURE]`
- `[REFACTOR]`
- `[DOCS]`
- `[TEST]`
- `[PERF]`
- `[SECURITY]`

## 2. Branches

As branches devem seguir o padrão:

`<tipo>/<issue>-<descricao>`

Exemplo:

`refactor/42-product-controller`

## 3. Commits

O projeto utiliza Conventional Commits.

Formato:

`<type>(<scope>): <description>`

Exemplo:

`refactor(controller): simplify ProductController`

## 4. Pull Requests

Toda alteração deve ser enviada através de Pull Request.

O PR deve:

- estar relacionado a uma Issue;
- possuir descrição clara;
- possuir testes quando necessário;
- passar nos checks do CI;
- seguir o padrão de commits.

## 5. Code Review

Não faça merge de alterações que:

- não passam nos testes;
- introduzem problemas conhecidos;
- não seguem os padrões do projeto;
- não possuem justificativa para alterações significativas.

## 6. Segurança

Nunca publique:

- senhas;
- tokens;
- API keys;
- arquivos `.env`;
- credenciais;
- informações privadas.

Problemas de segurança devem ser reportados de maneira privada quando possível.
