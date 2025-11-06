package br.com.wakax.consultasesqueleto.fipe.application.service;

import br.com.wakax.consultasesqueleto.fipe.api.VeiculoResponseDTO;
import br.com.wakax.consultasesqueleto.fipe.application.repository.FipeRepository;
import br.com.wakax.consultasesqueleto.fipe.domain.Marca;
import br.com.wakax.consultasesqueleto.fipe.domain.TipoVeiculo;
import br.com.wakax.consultasesqueleto.fipe.domain.Veiculo;
import br.com.wakax.consultasesqueleto.handler.APIException;
import br.com.wakax.consultasesqueleto.handler.ErrorCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FipeApplicationServiceTest {

    @Mock
    private FipeRepository fipeRepository;

    @InjectMocks
    private FipeApplicationService fipeApplicationService;

    private TipoVeiculo tipoVeiculo;
    private String idMarca;
    private String idModelo;
    private String idAno;
    private Veiculo veiculoDominio;

    @BeforeEach
    void setUp() {
        // Configuração inicial comum para os testes
        tipoVeiculo = TipoVeiculo.CARROS;
        idMarca = "22";
        idModelo = "444";
        idAno = "2015-1";

        veiculoDominio = new Veiculo(
                1,
                "R$ 25.000,00",
                "Fiat",
                "Palio",
                2015,
                "Gasolina",
                "001272-5",
                "novembro de 2025",
                "G"
        );
    }

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
    void deveRetornarValorVeiculo() {
        when(fipeRepository.buscarValorVeiculo(tipoVeiculo, idMarca, idModelo, idAno))
                .thenReturn(veiculoDominio);
        VeiculoResponseDTO resultado = fipeApplicationService.consultarValorVeiculo(tipoVeiculo, idMarca, idModelo, idAno);
        assertNotNull(resultado);
        assertEquals(veiculoDominio.valor(), resultado.getValor());
        assertEquals(veiculoDominio.marca(), resultado.getMarca());
        assertEquals(veiculoDominio.modelo(), resultado.getModelo());
        assertEquals(veiculoDominio.anoModelo(), resultado.getAnoModelo());
        assertEquals(veiculoDominio.codigoFipe(), resultado.getCodigoFipe());
        verify(fipeRepository, times(1)).buscarValorVeiculo(tipoVeiculo, idMarca, idModelo, idAno);
    }

    @Test
    void deveLancarAPIException() {
        APIException exceptionEsperada = new APIException(HttpStatus.NOT_FOUND, ErrorCode.FIPE_DADOS_NAO_ENCONTRADOS);
        when(fipeRepository.buscarValorVeiculo(tipoVeiculo, idMarca, idModelo, idAno))
                .thenThrow(exceptionEsperada);
        APIException exceptionLancada = assertThrows(APIException.class, () -> {
            fipeApplicationService.consultarValorVeiculo(tipoVeiculo, idMarca, idModelo, idAno);
        });
        assertEquals(HttpStatus.NOT_FOUND, exceptionLancada.getStatusException());
        assertEquals(ErrorCode.FIPE_DADOS_NAO_ENCONTRADOS, exceptionLancada.getErrorCode());
        verify(fipeRepository, times(1)).buscarValorVeiculo(tipoVeiculo, idMarca, idModelo, idAno);
    }

}