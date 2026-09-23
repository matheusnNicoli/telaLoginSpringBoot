package com.example.telaLoginMat.model;
//aqui importamos uma anotção pra instruir o framework o papel da classe, método ou variável
// no caso vamos falar pro db oq é id, apenas ter nome de id n é suficiente
import org.springframework.data.annotation.Id;
// aqui vamos no funcionalidades centrais(core) do mongo db
// e o mapping mapea a classe pro modelo usado no db cm um json, e vamos anotar q a classe vai ser um documento no db 
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "user")
public class UserEntity {
    @Id
    private String id;
    private String nome;
    private String email;
    private String cpf;
    private String corporacao;
    private String senha;

    public UserEntity(String id,String nome,String email,String cpf,String corporacao){
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.corporacao = corporacao;
    }

   public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getCorporacao() {
        return corporacao;
    }

    public void setCorporacao(String corporacao) {
        this.corporacao = corporacao;
    }

}
