package br.fynansis.Fynansis.entities;

import br.fynansis.Fynansis.dtos.AporteDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "aporte")
public class Aporte {

    @Id
    @Column(name = "cod_aporte")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID codAporte;

    @Column(name = "data_compra", nullable = false)
    private Date dataCompra;


    @Column(name = "valor_compra", nullable = false, precision = 10, scale = 2)
    private BigDecimal valorCompra;

    @Column(name = "num_cotas", precision = 10, scale = 2)
    private BigDecimal numCotas;

    @Column(name = "data_criacao", nullable = false)
    private Date dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    private Date dataAtualizacao;


    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "cod_usuario")
    private Usuario codUsuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "cod_investimento")
    private Investimento codInvestimento;

    public Aporte(AporteDTO aporteDTO, Investimento investimento) {
        Date dataAtual = retornaDataAtual();
        this.dataCompra = aporteDTO.getDataCompra();
        this.numCotas = aporteDTO.getNumCotas();
        this.valorCompra = aporteDTO.getValorCompra();
        this.codInvestimento = investimento;
        this.codUsuario = investimento.getCodUsuario();
        this.dataCriacao = dataAtual;
        this.dataAtualizacao = dataAtual;
    }

    public Aporte() {

    }

    public UUID getCodAporte() {
        return codAporte;
    }

    public void setCodAporte(UUID codAporte) {
        this.codAporte = codAporte;
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

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public Usuario getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Usuario codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Investimento getCodInvestimento() {
        return codInvestimento;
    }

    public void setCodInvestimento(Investimento codInvestimento) {
        this.codInvestimento = codInvestimento;
    }

    public Date retornaDataAtual() {
        return new Date();
    }

    public Aporte atualizaAporte(AporteDTO aporteDTO){
        setDataCompra(aporteDTO.getDataCompra());
        setNumCotas(aporteDTO.getNumCotas());
        setValorCompra(aporteDTO.getValorCompra());
        setDataAtualizacao(retornaDataAtual());
        return this;
    }
}
