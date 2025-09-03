package br.com.wakax.consultasesqueleto.fipe.infra;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "fipe-api", url = "${fipe.api.base-url}")
public interface FipeFeignClient {

}

