package ifpr.pgua.eic.trabalhosemestral.telas;

import java.time.LocalDate;
import java.util.ArrayList;

import ifpr.pgua.eic.trabalhosemestral.models.Aluno;
import ifpr.pgua.eic.trabalhosemestral.repository.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroAluno {

    public Button btListarAlunos;
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfTelefone;

    @FXML
    private DatePicker dtDataMatricula;

    private Escola escola;

    public CadastroAluno(Escola escola){
        this.escola = escola;
    }

    @FXML
    private void limpar(ActionEvent event){
        tfNome.setText("");
        tfEmail.setText("");
        tfCpf.setText("");
        tfTelefone.setText("");
    }

    @FXML
    private void cadastrar(ActionEvent event){

        String nome = tfNome.getText();
        String email = tfEmail.getText();
        String cpf = tfCpf.getText();
        String telefone = tfTelefone.getText();
        LocalDate dataMatricula = dtDataMatricula.getValue();

        String dataMatriculaString = "";

        if (dataMatricula != null){
            dataMatriculaString = dataMatricula.toString();
        }

        LocalDate localTeste = null ;

        boolean flag = true;
        String msg = "";
        System.out.println("Data String: "+dataMatricula);

        if(nome.isEmpty() || nome.isBlank()){
            msg += "Nome não pode ser vazio!";
            flag = false;
        }

        if(cpf.isEmpty() || cpf.isBlank()){
            msg += "\nCPF não pode ser vazio!";
            flag = false;
        }

        if(email.isEmpty() || email.isBlank()){
            msg += "\nEmail não pode ser vazio!";
            flag = false;
        }

        if (telefone.isEmpty() || telefone.isBlank()){
            msg += "\nTelefone não pode ser Vazio!";
            flag = false;
        }

        if (dataMatriculaString.isEmpty() || dataMatriculaString.isBlank()){
            msg += "\nData de Matricula não pode ser vazio!";
            flag = false;
        }

        if(flag){
            boolean ret = escola.cadastrarAluno(nome, cpf, email,telefone,dataMatricula);
            if(ret){
                System.out.println(escola.getAlunos());

                limpar(null);

                msg = "Aluno cadastrado!";
            }else{
                msg = "Aluno não cadastrado!";
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION,msg,ButtonType.OK);
        alert.showAndWait();

    }

    
}