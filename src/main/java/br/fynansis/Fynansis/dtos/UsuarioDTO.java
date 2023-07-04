package br.fynansis.Fynansis.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO {

    private String nome;
    private String email;
    private String login;
    private String senha;
    private String cpf;

    public UsuarioDTO(@JsonProperty("nome") String nome, @JsonProperty("email") String email, @JsonProperty("login") String login, @JsonProperty("senha") String senha, @JsonProperty("cpf") String cpf) {

        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
