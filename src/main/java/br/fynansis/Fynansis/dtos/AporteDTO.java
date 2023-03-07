package br.fynansis.Fynansis.dtos;

import java.math.BigDecimal;
import java.util.Date;

public class AporteDTO {

    private Date dataCompra;

    private BigDecimal valorCompra;

    private BigDecimal numCotas;

    public AporteDTO(Date dataCompra, BigDecimal valorCompra, BigDecimal numCotas) {
        this.dataCompra = dataCompra;
        this.valorCompra = valorCompra;
        this.numCotas = numCotas;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getNumCotas() {
        return numCotas;
    }

    public void setNumCotas(BigDecimal numCotas) {
        this.numCotas = numCotas;
    }
}
