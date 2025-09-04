package br.com.wakax.consultasesqueleto.handler;

public enum ErrorCode {
  FIPE_MARCA_NAO_ENCONTRADA("fipe.marca.nao.encontrada"),
  FIPE_MODELO_NAO_ENCONTRADO("fipe.modelo.nao.encontrado"),
  FIPE_ANO_NAO_ENCONTRADO("fipe.ano.nao.encontrado"),
  FIPE_API_ERRO("fipe.api.erro"),
  FIPE_LIMITE_EXCEDIDO("fipe.limite.excedido"),
  FIPE_SERVICO_INDISPONIVEL("fipe.servico.indisponivel"),
  FIPE_REQUISICAO_INVALIDA("fipe.requisicao.invalida"),
  FIPE_DADOS_NAO_ENCONTRADOS("fipe.dados.nao.encontrados");

  private final String code;

  ErrorCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }
}
