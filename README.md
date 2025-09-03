# consultasesqueleto

Esqueleto de serviço Spring Boot (Java 17) para consultas FIPE/CEP, com camadas e integrações preparadas, porém sem endpoints implementados. Use este módulo como base para evoluir por tasks.

## O que contém
- Estrutura de pacotes por domínio (fipe, cep) e comum (common)
- Camadas: API (interface + controller), Application Service (interface + implementação), Repository (interface), Infra (Feign client + repository)
- OpenFeign habilitado e configurado (log BASIC por padrão)
- `application.yml` com context-path `/consultasesqueleto/api` e URLs externas parametrizadas
- Record reutilizável `ErrorResponse` em `common.domain`

## O que não contém (por escolha)
- Métodos/paths de endpoints na API (interfaces vazias)
- Métodos de serviço e repositório (interfaces vazias)
- Mapeamentos de payload específicos de FIPE/CEP (records de domínio)

## Diretrizes sobre records (reuso vs. específicos)
- Reutilizáveis (podem ser usados individualmente em qualquer task):
  - `common.domain.ErrorResponse(code, message, traceId, timestamp)`
- Não incluídos no esqueleto (devem nascer junto da task que usa):
  - Records específicos de integrações FIPE (ex.: `Marca`, `Modelo`, `Ano`, `ModelosResponse`, `VeiculoFipe`)
  - Records específicos de CEP (ex.: `EnderecoViaCep`, `Endereco`)

Racional: manter baixo acoplamento; cada task introduz o contrato realmente necessário.

## Próximos passos típicos por task
1. Definir record(s) de domínio necessários (ex.: `Marca`, `Endereco`) na pasta do domínio
2. Adicionar assinatura ao `Service` e ao `Repository`
3. Criar método correspondente no `Controller` e no `FeignClient`
4. Implementar o `RepositoryFeign` chamando o client
5. Validar no `Service` (regras) e retornar
6. Acrescentar testes unitários/integrados e documentação OpenAPI

## Execução
- Compilar: `mvn -q -f consultasesqueleto/pom.xml clean package`
- Rodar: `mvn -q -f consultasesqueleto/pom.xml spring-boot:run`

Context path: `http://localhost:8080/consultasesqueleto/api`

