package br.fynansis.Fynansis.entities;

import br.fynansis.Fynansis.dtos.UsuarioDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "cod_usuario")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer codUsuario;
    @Column(name = "nome_usuario", nullable = false)
    @NotBlank
    private String nomeUsuario;
    @Column(name = "email_usuario", unique = true, nullable = false)
    @NotBlank
    private String emailUsuario;
    @Column(name = "login_usuario", unique = true, nullable = false, length = 20)
    @NotBlank
    @Size(min = 5, max = 20)
    private String loginUsuario;
    @Column(name = "senha_usuario", nullable = false, length = 30)
    @NotBlank
    @Size(min = 12, max = 30)
    private String senhaUsuario;
    @Column(name = "cpf_usuario", unique = true, nullable = false, length = 11)
    @NotBlank
    @Size(min = 11, max = 11)
    private String cpfUsuario;

    public Usuario(UsuarioDTO usuarioDTO) {
        this.nomeUsuario  = usuarioDTO.getNome();
        this.emailUsuario = usuarioDTO.getEmail();
        this.loginUsuario = usuarioDTO.getLogin();
        this.senhaUsuario = usuarioDTO.getSenha();
        this.cpfUsuario   = usuarioDTO.getCpf();
    }

    public Usuario() {

    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public String getLoginUsuario() {
        return loginUsuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getCpfUsuario() {
        return cpfUsuario;
    }

    public void setCpfUsuario(String cpfUsuario) {
        this.cpfUsuario = cpfUsuario;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Usuario atualizaUsuario(UsuarioDTO usuarioDTO){
        setNomeUsuario(usuarioDTO.getNome());
        setSenhaUsuario(usuarioDTO.getSenha());
        setLoginUsuario(usuarioDTO.getLogin());
        return this;
    }
}
