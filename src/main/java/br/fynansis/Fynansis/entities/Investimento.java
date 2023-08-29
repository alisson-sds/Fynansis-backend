package br.fynansis.Fynansis.entities;

import br.fynansis.Fynansis.dtos.InvestimentoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "investimento")
public class Investimento {

    @Id
    @Column(name = "cod_investimento")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID codInvestimento;

    @Column(name = "desc_investimento")
    @Size(max = 50)
    private String descricao;

    @Column(name = "sigla_investimento")
    @Size(min = 3, max = 10)
    private String sigla;

    @Column(name = "tipo_investimento", nullable = false)
    @Size(max = 30)
    private String tipo;

    @Column(name = "inst_investimento")
    @Size(max = 30)
    private String instituicao;

    @Column(name = "data_criacao", nullable = false)
    private Date dataCriacao;

    @Column(name = "data_atualizacao", nullable = false)
    private Date dataAtualizacao;
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JoinColumn(name = "cod_usuario")
    private Usuario usuario;


    @OneToMany(mappedBy = "codInvestimento", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Aporte> aportes = new ArrayList<>();

    public Investimento(InvestimentoDTO investimentoDTO, Usuario codUsuario) {
        Date dataAtual = retornaDataAtual();
        this.descricao = investimentoDTO.getDescricao();
        this.sigla = investimentoDTO.getSigla();
        this.tipo = investimentoDTO.getTipo();
        this.instituicao = investimentoDTO.getInstituicao();
        this.usuario = codUsuario;
        this.dataCriacao = dataAtual;
        this.dataAtualizacao = dataAtual;

    }

    public Investimento() {

    }

    public UUID getCodInvestimento() {
        return codInvestimento;
    }

    public void setCodInvestimento(UUID codInvestimento) {
        this.codInvestimento = codInvestimento;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date retornaDataAtual() {
        return new Date();
    }

    public List<Aporte> getAportes() {
        return aportes;
    }

    public Investimento atualizaInvestimento(InvestimentoDTO investimentoDTO) {
        setDescricao(investimentoDTO.getDescricao());
        setSigla(investimentoDTO.getSigla());
        setTipo(investimentoDTO.getTipo());
        setInstituicao(investimentoDTO.getInstituicao());
        setDataAtualizacao(retornaDataAtual());
        return this;
    }

}
