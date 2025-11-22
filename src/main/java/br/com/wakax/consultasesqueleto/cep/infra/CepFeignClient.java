package br.com.wakax.consultasesqueleto.cep.infra;

import br.com.wakax.consultasesqueleto.cep.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep-api", url = "${viacep.api.base-url}")
public interface CepFeignClient {

    @GetMapping("/ws/{cep}/json/")
    ViacepResponse buscarPorCep(@PathVariable("cep") String cep);

}

