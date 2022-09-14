package ifpr.pgua.eic.trabalhosemestral.telas;

import java.util.ArrayList;

import ifpr.pgua.eic.trabalhosemestral.models.Professor;
import ifpr.pgua.eic.trabalhosemestral.repository.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import static java.lang.Integer.parseInt;

public class CadastroCurso {

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfCarga;

    

    @FXML
    private TextField tfDescricao;

    @FXML
    private ComboBox<Professor> cbProfessores;
    

   



    private Escola escola;

    public CadastroCurso(Escola escola){
        this.escola = escola;
    }

    public void initialize() {
        cbProfessores.getItems().clear();
        cbProfessores.getItems().addAll(escola.getProfessores());
        
        


    }

    

    

    @FXML
    private void cadastrar(ActionEvent event){

        Professor professor = cbProfessores.getSelectionModel().getSelectedItem();
        String nome = tfNome.getText();
        String descricao = tfDescricao.getText();
        String cargaHorariaString = Integer.toString(parseInt(tfCarga.getText()));
        String codigoString = Integer.toString(parseInt(tfCodigo.getText()));
        int codigoInt = parseInt(tfCodigo.getText());
        int cargaHorariaInt  = parseInt(tfCarga.getText());


        boolean flag = true;
        String msg = "";


        if(nome.isEmpty() || nome.isBlank()){
            msg = "Nome não pode ser vazio!";
            flag = false;
        }

        if(descricao.isEmpty() || descricao.isBlank()){
            msg += "\nDescricao não pode ser vazio!";
            flag = false;
        }

        if(cargaHorariaString.isBlank() || cargaHorariaString.isEmpty()){
            msg += "\nCarga horaria não pode ser vazio";
            flag = false;
        }
        if(professor == null){
            msg += "\nSelecione um Professor para continuar";
            flag = false;
        }

        if (codigoString.isEmpty() || codigoString.isBlank() || codigoInt == 0){
            msg += "\nCodigo não pode ser vazio!";
            flag = false;
        }

        if(flag){
            boolean ret = escola.cadastrarCurso(nome, codigoInt, descricao, cargaHorariaInt, professor);
            if(ret){
                System.out.println(escola.getCursos());

               

                msg = "Curso cadastrado!";
            }else{
                msg = "Curso não cadastrado! Codigo repetido!";
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION,msg, ButtonType.OK);
        alert.showAndWait();

    }
}

