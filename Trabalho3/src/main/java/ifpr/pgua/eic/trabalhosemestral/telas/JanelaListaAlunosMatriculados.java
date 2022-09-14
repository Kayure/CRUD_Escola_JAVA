package ifpr.pgua.eic.trabalhosemestral.telas;

import ifpr.pgua.eic.trabalhosemestral.models.Aluno;
import ifpr.pgua.eic.trabalhosemestral.models.Curso;
import ifpr.pgua.eic.trabalhosemestral.repository.Escola;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;

public class JanelaListaAlunosMatriculados {
    
    @FXML
    private ListView<Aluno> listaMatriculados;

    @FXML
    private ComboBox<Curso> cbCursos;

    
    private Escola escola;

    public JanelaListaAlunosMatriculados(Escola escola){
        this.escola = escola;
    }

    public void initialize(){
        cbCursos.getSelectionModel().clearSelection();
        cbCursos.getItems().addAll(escola.getCursos());
    }

    @FXML
    private void busca(ActionEvent event){
        Curso curso = cbCursos.getSelectionModel().getSelectedItem();
        listaMatriculados.getItems().clear();
        
        String msg = "";
        boolean flag = true;

        if(curso == null){
            msg += "Deve ser selecionado o curso!";
            flag = false;

            Alert alert = new Alert(AlertType.INFORMATION,msg,ButtonType.OK);
            alert.showAndWait();
        }else{
            listaMatriculados.getItems().addAll(escola.listarAlunosMatriculados(curso));
        }
    }

    @FXML
    private void alunosMatriculados(){
        Curso curso = cbCursos.getSelectionModel().getSelectedItem();
        listaMatriculados.getItems().clear();
        
        if(curso == null){
            Alert alert = new Alert(AlertType.INFORMATION,"Curso não pode ser vazio!");
            alert.showAndWait();
        }else{
            listaMatriculados.getItems().addAll(escola.listarAlunosMatriculados(curso));
        }
    }
}
