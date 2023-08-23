package br.fynansis.Fynansis.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InvestimentoDTO {

    private String descricao;
    private String sigla;
    private String tipo;
    private String instituicao;

    public InvestimentoDTO(@JsonProperty("descricao") String descricao,
                           @JsonProperty("sigla") String sigla,
                           @JsonProperty("tipo") String tipo,
                           @JsonProperty("instituicao") String instituicao) {
        this.descricao = descricao;
        this.sigla = sigla;
        this.tipo = tipo;
        this.instituicao = instituicao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }
}
