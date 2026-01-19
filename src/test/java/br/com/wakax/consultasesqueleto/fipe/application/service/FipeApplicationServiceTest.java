package br.com.wakax.consultasesqueleto.fipe.application.service;

import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.Modelo;
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
    void deveListarMarcasComSucesso() {

        TipoVeiculo tipoVeiculo = TipoVeiculo.CARROS;
        List<Marca> marcasEsperadas = List.of(
                new Marca("1", "Fiat"),
                new Marca("2", "Ford")
        );
        when(fipeRepository.listarMarcas(tipoVeiculo)).thenReturn(marcasEsperadas);
        List<Marca> resultado = fipeApplicationService.listarMarcas(tipoVeiculo);
        assertEquals(marcasEsperadas, resultado);
        verify(fipeRepository).listarMarcas(tipoVeiculo);
    }

    @Test
    void deveListarModelosComSucesso() {

        String codigoMarca = "21";
        String tipoVeiculo = "CARROS";
        List<Modelo> modelos = List.of(
                new Modelo("1", "Argo"),
                new Modelo("2", "Palio")
        );
        when(fipeRepository.listarModelos(codigoMarca, tipoVeiculo)).thenReturn(modelos);
        List<Modelo> resultado = fipeApplicationService.listarModelos(codigoMarca, tipoVeiculo);
        assertEquals(modelos, resultado);
        verify(fipeRepository).listarModelos(codigoMarca, tipoVeiculo);
    }
}