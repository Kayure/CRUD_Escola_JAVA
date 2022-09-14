package ifpr.pgua.eic.trabalhosemestral.telas;

import java.util.ArrayList;

import ifpr.pgua.eic.trabalhosemestral.models.Professor;
import ifpr.pgua.eic.trabalhosemestral.repository.Escola;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastroProfessor {

    @FXML
    public Button btListarProfessores;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfSalario;


    private Escola escola;

    public CadastroProfessor(Escola escola){
        this.escola = escola;
    }

    
    @FXML
    private void limpar(){
        tfNome.clear();
        tfEmail.clear();
        tfCpf.clear();
        tfSalario.clear();
        tfTelefone.clear();
    }

    @FXML
    private void cadastrar(){

        String nome = tfNome.getText();
        String cpf = tfCpf.getText();
        String email = tfEmail.getText();
        String telefone = tfTelefone.getText();
        double salario = Double.valueOf(tfSalario.getText());


        boolean flag = true;
        String msg = "";


        if(nome.isEmpty() || nome.isBlank()){
            msg += "Nome não pode ser vazio!";
            flag = false;
        }

        if(cpf.isEmpty() || cpf.isBlank()){
            msg += "\nCPF não pode ser vazio!";
            flag = false;
        }

        if (telefone.isEmpty() || telefone.isBlank()){
            msg += "\nTelefone não pode ser vazio!";
            flag = false;
        }

        if(email.isEmpty() || email.isBlank()){
            msg += "\nEmail não pode ser vazio!";
            flag = false;
        }

        if(flag){
            boolean ret = escola.cadastrarProfessor(nome, cpf, email, telefone, salario);
            if(ret){

                limpar();

                msg = "Professor cadastrado!";
            }else{
                msg = "ERRO!!! CPF já Cadastrado!";
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION,msg,ButtonType.OK);
        alert.showAndWait();

    }
}

