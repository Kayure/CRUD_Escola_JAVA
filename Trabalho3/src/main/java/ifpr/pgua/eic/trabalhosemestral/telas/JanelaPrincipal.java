package ifpr.pgua.eic.trabalhosemestral.telas;

import ifpr.pgua.eic.trabalhosemestral.App;
import ifpr.pgua.eic.trabalhosemestral.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;

public class JanelaPrincipal {




    @FXML
    private void carregaTelaCadastroAluno(ActionEvent evento){
        App.changeScreenRegion("CADASTRO ALUNO",BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaCadastroProf(ActionEvent evento){
        App.changeScreenRegion("CADASTRO PROFESSOR",BorderPaneRegion.CENTER);
       
    }

    @FXML
    private void carregaTelaCadastroCurso(ActionEvent evento){
        App.changeScreenRegion("CADASTRO CURSO",BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaMatriculaAluno(ActionEvent evento){
        App.changeScreenRegion("MATRICULA",BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaListas(ActionEvent evento){
        App.changeScreenRegion("LISTAS",BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaListaMatriculados(ActionEvent evento){
        App.changeScreenRegion("LISTAS MATRICULADOS",BorderPaneRegion.CENTER);
    }


    

    



    

   
    }


