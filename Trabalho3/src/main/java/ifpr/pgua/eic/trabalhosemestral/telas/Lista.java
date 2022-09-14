package ifpr.pgua.eic.trabalhosemestral.telas;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.trabalhosemestral.models.Aluno;
import ifpr.pgua.eic.trabalhosemestral.models.Curso;
import ifpr.pgua.eic.trabalhosemestral.models.Pessoa;
import ifpr.pgua.eic.trabalhosemestral.models.Professor;
import ifpr.pgua.eic.trabalhosemestral.repository.Escola;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Lista {

    @FXML
    public TextArea atualizaStatusAluno;

    @FXML
    public TextArea atualizaStatusCurso;

    @FXML
    public TextField tfBuscaPessoa;

    @FXML
    public TextField tfBuscaCurso;

    @FXML
    public ToggleButton tgbAlunos;

    @FXML
    public ToggleButton tgbProfessores;

    String pessoa = "aluno";

    @FXML
    private ListView<Curso> ltvCursos;

    @FXML
    private ListView<Aluno> ltvAlunos;

    @FXML
    private ListView<Professor> ltvProfessores;


    private Escola escola;

    public Lista(Escola escola) {
        this.escola = escola;
    }

    public void initialize(){

        ltvAlunos.getItems().addAll(escola.getAlunos());
        ltvProfessores.getItems().addAll(escola.getProfessores());
        ltvCursos.getItems().addAll(escola.getCursos());

        
    }   

}
