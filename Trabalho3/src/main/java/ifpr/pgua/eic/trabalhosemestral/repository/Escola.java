package ifpr.pgua.eic.trabalhosemestral.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import ifpr.pgua.eic.trabalhosemestral.models.Aluno;
import ifpr.pgua.eic.trabalhosemestral.models.Curso;
import ifpr.pgua.eic.trabalhosemestral.models.Pessoa;
import ifpr.pgua.eic.trabalhosemestral.models.Professor;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Alert.AlertType;

public class Escola {

    // DECLARAÇÃO DE VARIAVEIS E ARRAYLIST
    private String nome;
    private String telefone;

    private ArrayList<Professor> professores;
    private ArrayList<Aluno> alunos;
    private ArrayList<Curso> cursos;
    private ArrayList<Pessoa> pessoas;

    // DEFINE O ARQUIVO BINARIO QUE SERÁ SALVO OS DADOS
    private static final String NOME_ARQUIVO_BIN = "dados.bin";

    public Escola(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;

        this.alunos = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.professores = new ArrayList<>();
    }

    // ADICIONA FAKES PARA NÃO PRECISAR FICAR POVOANDO
    public void criaFakes() {

        alunos.clear();
        Aluno aluno1 = new Aluno("Luccas Kayure", "102146133933", "Kayure@teste.com", "997084541",
                LocalDate.of(2019, 6, 9));
        alunos.add(aluno1);

        professores.clear();
        Professor professor1 = new Professor("103.037.008-21", "Valerio", "Valerio@teste.com", "7070", 20000.00);
        professores.add(professor1);

        cursos.clear();
        Curso curso1 = new Curso("Orientação a objetos", 1, "curso dificil", 300, getProfessores().get(0));
        cursos.add(curso1);
    }

    // METODOS PARA CADASTRAR
    public boolean cadastrarAluno(String nome, String cpf, String email, String telefone, LocalDate dataMatricula) {
        if (this.alunos != null) {
            Aluno a = new Aluno(nome, cpf, email, telefone, dataMatricula);
            if (buscaAluno(cpf) == null) {
                alunos.add(a);
                return true;
            }
        }
        return false;
    }

    

    public boolean cadastrarProfessor(String nome, String cpf, String email, String telefone, Double salario) {
        if (this.professores != null) {
            Professor a = new Professor(nome, cpf, email, telefone, salario);
            if (buscaProfessor(cpf) == null) {
                professores.add(a);
                return true;
            }
        }
        return false;
    }

    public boolean cadastrarCurso(String nome, int codigo, String descricao, int cargaHoraria, Professor professor) {
        if (this.cursos != null) {
            if (verificaCurso(codigo)) {
                Curso a = new Curso(nome, codigo, descricao, cargaHoraria, professor);
                cursos.add(a);
                return true;
            }
        }
        return false;
    }

    //METODOS DA MATRICULA
    public boolean matricularAluno(Aluno aluno, Curso curso) {
        if (this.cursos != null && this.alunos != null) {
            return curso.matricula(aluno);
        }
        return false;
    }

    public boolean desmatricular(Aluno aluno, Curso curso) {
        System.out.println("Aluno : " + aluno.getCpf());
        if (this.cursos != null && this.alunos != null) {
            curso.desmatricula(aluno.getCpf());
            return true;
        }
        return false;
    }


    // LISTAR 

    public ArrayList<Aluno> listarAlunosMatriculados(Curso curso) {
        if (this.cursos != null) {
            return curso.getAlunos();
        }
        return null;
    }

    //METODOS DE BUSCA

    public Aluno buscaAluno(String cpf) {
        for (Aluno a : alunos) {
            if (a.getCpf().equals(cpf)) {
                return a;
            }
        }
        return null;
    }

    public Professor buscaProfessor(String cpf) {
        for (Professor a : professores) {
            if (a.getCpf().equals(cpf)) {
                return a;
            }
        }
        return null;
    }

    public Curso buscaCurso(String nome) {
        for (Curso a : cursos) {
            if (a.getNome().equals(nome)) {
                return a;
            }
        }
        return null;
    }
    

    //VERIFICA SE CURSO JA EXISTE
    public Boolean verificaCurso(int codigo) {
        for (Curso a : cursos) {
            if (a.getCodigo() == codigo) {
                return false;
            }
        }
        return true;
    }

    // SALVAR EM ARQUIVO BINARIO 
    //obs: essa parte eu não lembrava como fazia então tive
    // que pegar da internet

    public void salvarArquivoBin() throws IOException {
        File arq = new File(NOME_ARQUIVO_BIN);
        FileOutputStream fos = new FileOutputStream(arq);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(professores);
        oos.writeObject(alunos);
        oos.writeObject(cursos);

        oos.close();
        fos.close();
    }

    public void carregarArquivosBin() throws IOException, ClassNotFoundException {
        File arq1 = new File(NOME_ARQUIVO_BIN);
        FileInputStream fis = new FileInputStream(arq1);
        ObjectInputStream ois = new ObjectInputStream(fis);

        professores = (ArrayList) ois.readObject();
        alunos = (ArrayList) ois.readObject();
        cursos = (ArrayList) ois.readObject();

        ois.close();
        fis.close();
    }

    //GETS DOS ARRAYLIST
    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

}
