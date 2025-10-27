package br.com.wakax.consultasesqueleto.fipe.infra;


import br.com.wakax.consultasesqueleto.fipe.api.FipeApiResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "fipe-api", url = "${fipe.api.base-url}", configuration = FeignConfig.class)
//classe cliente da api da fipe
public interface FipeFeignClient {
    @GetMapping("/{tipoVeiculo}/marcas/{idMarca}/modelos/{idModelo}/anos/{idAno}")
    FipeApiResponseDTO buscarValorVeiculo(
            @PathVariable("idMarca") String idMarca,
            @PathVariable("idModelo") String idModelo,
            @PathVariable("idAno") String idAno,
            @RequestParam("tipoVeiculo") String tipoVeiculo
    );
}
