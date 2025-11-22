package br.com.wakax.consultasesqueleto.cep.api;

import br.com.wakax.consultasesqueleto.cep.infra.ViacepResponse;
import org.springframework.web.bind.annotation.RestController;

import br.com.wakax.consultasesqueleto.cep.application.service.CepService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@Slf4j
public class CepController implements CepAPI {

  private final CepService cepService;

    @Override
    public ViacepResponse buscaEnderecoPorCep(String cep) {
        log.info("[inicia] CepController - EnderecoDetalhadoResponse");
        ViacepResponse endereco = cepService.buscaEnderecoPorCep(cep);
        log.info("[finaliza] CepController - EnderecoDetalhadoResponse");
        return endereco;
    }
}

