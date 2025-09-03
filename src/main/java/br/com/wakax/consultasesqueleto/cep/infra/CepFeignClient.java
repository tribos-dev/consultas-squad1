package br.com.wakax.consultasesqueleto.cep.infra;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "viacep-api", url = "${viacep.api.base-url}")
public interface CepFeignClient {

}

