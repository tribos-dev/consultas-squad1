package br.com.wakax.consultasesqueleto.cep.api;

import br.com.wakax.consultasesqueleto.cep.infra.ViacepResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public interface CepAPI {

    @GetMapping(value = "/{cep}")
    @ResponseStatus(code = HttpStatus.OK)
    ViacepResponse buscaEnderecoPorCep(@PathVariable String cep);

}

