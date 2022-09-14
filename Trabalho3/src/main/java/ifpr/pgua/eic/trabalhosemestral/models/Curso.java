package ifpr.pgua.eic.trabalhosemestral.models;

import java.io.Serializable;
import java.util.ArrayList;


public class Curso implements Serializable {
    
    private int codigo;
    private String nome;
    private String descricao;
    private int cargaHoraria;
    private  Professor professor;

    private ArrayList<Aluno> alunos;


    public Curso(String nome, int codigo, String descricao, int cargaHoraria, Professor professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public boolean matricula(Aluno aluno){
        if(this.alunos != null){
            if (aluno.getCpf() !=null ) {
                for (Aluno a : alunos ) {
                    if (a.getCpf().equals(aluno.getCpf())) {
                        System.out.println("pula");
                        return false;
                    }
                }
                alunos.add(aluno);
                System.out.println("aluno:"+alunos);
                return true;
            }
        }
        return false;
    }

    public boolean desmatricula(String cpf){
        for (Aluno a :alunos){
            if (a.getCpf().equals(cpf)){
                System.out.println("alunos: "+alunos);
                alunos.remove(a);
                return true;
            }
        }
        return false;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

   
    @Override
    public String toString() {
        return  " CURSO: " +getNome()+
                "\n PROFESSOR: "+professor.getNome()+
                "\n CODIGO: " +getCodigo()+
                "\n DESCRICAO:"+getDescricao()+
                "\n CARGA HORARIA:"+getCargaHoraria();
    }
   

    String infAluno;


    public String paraTexto(){

        return  "Curso:"+getNome()+
                    ";Professor:"+professor.getCpf()+
                    ";codigo:"+getCodigo()+
                    ";descricao:"+getDescricao()+
                    ";carga Horaria:"+getCargaHoraria();
    }

    public String salvaAluno(){
        String sisAluno = "";
        for (Aluno a : alunos) {
            sisAluno += ";cpf-aluno:" + a.getCpf();
        }

        return  "Codigo:"+getCodigo() +sisAluno;

    }

}