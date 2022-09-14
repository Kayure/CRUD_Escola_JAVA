package ifpr.pgua.eic.trabalhosemestral.telas;

import ifpr.pgua.eic.trabalhosemestral.models.Aluno;
import ifpr.pgua.eic.trabalhosemestral.models.Curso;
import ifpr.pgua.eic.trabalhosemestral.repository.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;

public class Matricula {
    
    @FXML
    private ComboBox<Aluno>cbAluno;

    @FXML
    private ComboBox<Curso> cbCurso;

    private Escola escola;

    public Matricula (Escola escola){
        this.escola = escola;
    }

    public void initialize(){
        
        cbAluno.getItems().clear();
        cbAluno.getItems().clear();
        cbCurso.getItems().addAll(escola.getCursos());
        cbAluno.getItems().addAll(escola.getAlunos());
    }

    @FXML
    private void desmatricular(ActionEvent event){
        Aluno aluno = cbAluno.getSelectionModel().getSelectedItem();
        Curso curso = cbCurso.getSelectionModel().getSelectedItem();

        boolean flag = true;
        String msg = "";

        

        if(flag){
            boolean ret = escola.desmatricular(cbAluno.getSelectionModel().getSelectedItem(),cbCurso.getSelectionModel().getSelectedItem());
            if(ret){
                System.out.println("aluno desmatriculado com Sucesso");

                cbCurso.getSelectionModel().clearSelection();
                cbAluno.getSelectionModel().clearSelection();

                msg = "Aluno Desmatriculado!";
            }else{
                msg = "Não Foi possivel Desmatricular! Verifique as Informações!";
            }
        }


        Alert alert = new Alert(Alert.AlertType.INFORMATION,msg, ButtonType.OK);
        alert.showAndWait();

    }


    @FXML
    private void matricular(ActionEvent event){

        Aluno aluno  = cbAluno.getSelectionModel().getSelectedItem();
        Curso curso  = cbCurso.getSelectionModel().getSelectedItem();


        boolean flag = true;
        String msg = "";

        //nada Selecionado

        if(flag){
            boolean ret = escola.matricularAluno(aluno,curso);
            if(ret){
                System.out.println("aluno matriculado com Sucesso");

                cbCurso.getSelectionModel().clearSelection();
                cbAluno.getSelectionModel().clearSelection();

                msg = "Aluno Matriculado!";
            }else{
                msg = "Aluno não cadastrado! Verifique as Informações!";
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION,msg, ButtonType.OK);
        alert.showAndWait();

    }
}