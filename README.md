# consultas

Esqueleto de serviço Spring Boot (Java 17) para consultas FIPE/CEP, com camadas e integrações preparadas, porém sem endpoints implementados. Use este módulo como base para evoluir por tasks.

## O que contém
- Estrutura de pacotes por domínio (fipe, cep) e comum (common)
- Camadas: API (interface + controller), Application Service (interface + implementação), Repository (interface), Infra (Feign client + repository)
- OpenFeign habilitado e configurado (log BASIC por padrão)
- `application.yml` com context-path `/consultasesqueleto/api` e URLs externas parametrizadas
- Record reutilizável `ErrorResponse` em `common.domain`
