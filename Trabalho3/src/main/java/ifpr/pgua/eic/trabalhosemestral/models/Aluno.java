package ifpr.pgua.eic.trabalhosemestral.models;

import java.time.LocalDate;

public class Aluno extends Pessoa {
    private LocalDate dataMatricula = LocalDate.now();
    Aluno aluno;

    public Aluno(String nome, String cpf, String email, String telefone, LocalDate dataMatricula) {
        super(nome,cpf,email,telefone);
        this.dataMatricula = dataMatricula;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    @Override
    public String toString() {
        return super.toString()+               
                "\n DATA MATRICULA: "+dataMatricula+"\n";
    }

    public String paraTexto(){
        return super.paraTexto()+
                "DATA matricula:"+dataMatricula;
    }
}