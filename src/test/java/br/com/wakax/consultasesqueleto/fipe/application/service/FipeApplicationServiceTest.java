package br.com.wakax.consultasesqueleto.fipe.application.service;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FipeApplicationServiceTest {

    @Mock
    private FipeRepository fipeRepository;

    @InjectMocks
    private FipeApplicationService fipeApplicationService;

    @Test
    void deveListarMarcas() {
        TipoVeiculo tipoVeiculo = TipoVeiculo.CARROS;
        List<Marca> marcasEsperadas = List.of(
            new Marca("1", "Toyota"),
            new Marca("2", "Honda")
        );
        
        when(fipeRepository.listarMarcas(tipoVeiculo)).thenReturn(marcasEsperadas);
        List<Marca> resultado = fipeApplicationService.listarMarcas(tipoVeiculo);
        
        assertEquals(marcasEsperadas, resultado);
        verify(fipeRepository).listarMarcas(tipoVeiculo);
    }
}