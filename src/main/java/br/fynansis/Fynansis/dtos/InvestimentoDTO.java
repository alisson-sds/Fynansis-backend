package br.fynansis.Fynansis.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;

public class InvestimentoDTO {

    private String descricao;
    private String sigla;
    private String tipo;
    private String instituicao;

    public InvestimentoDTO(String descricao, String sigla, String tipo, String instituicao) {
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
