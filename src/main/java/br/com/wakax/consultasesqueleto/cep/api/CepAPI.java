package br.com.wakax.consultasesqueleto.cep.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cep")
public interface CepAPI {

    @GetMapping(value = "/{cep}")
    @ResponseStatus(code = HttpStatus.OK)
    EnderecoDetalhadoResponse buscaEnderecoPorCep(@PathVariable String cep);

}

