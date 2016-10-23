package model;

import java.util.Date;

public class Contato {

    private Long id;
    private String nome;
    private Date dtNascimento;
    private String email;
    private String telefone;
    private String sexo;
    private Date dtCadastro;

    public Contato() {
    }

    public Contato(String nome, Date dtNascimento, String email, String sexo, String telefone) {
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public Contato(Long id, String nome, Date dtNascimento, String email, String sexo, String telefone) {
        this.id = id;
        this.nome = nome;
        this.dtNascimento = dtNascimento;
        this.email = email;
        this.sexo = sexo;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
}