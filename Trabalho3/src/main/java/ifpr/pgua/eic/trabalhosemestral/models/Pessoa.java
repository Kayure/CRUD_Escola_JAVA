package ifpr.pgua.eic.trabalhosemestral.models;

import java.io.Serializable;

public abstract class Pessoa implements Serializable {

    private String cpf = "";
    private String nome = "";
    private String email = "";
    private String telefone = "";

    public Pessoa(String nome, String cpf, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @Override
    public String toString() {
        return  " NOME: " +getNome()+
                "\n CPF: "+getCpf()+
                "\n EMAIL: " +getEmail()+                
                "\n TELEFONE:" +getTelefone();
    }


    public String paraTexto(){
        return "NOME:"+getNome()+
                "\n CPF:"+getCpf()+
                "\n EMAIL:"+getEmail()+
                "\n TELEFONE:"+getTelefone();
    }
}

