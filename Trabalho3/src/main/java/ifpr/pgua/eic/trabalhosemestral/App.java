package ifpr.pgua.eic.trabalhosemestral;

import java.io.IOException;

import ifpr.pgua.eic.trabalhosemestral.repository.Escola;
import ifpr.pgua.eic.trabalhosemestral.telas.CadastroAluno;
import ifpr.pgua.eic.trabalhosemestral.telas.CadastroCurso;
import ifpr.pgua.eic.trabalhosemestral.telas.CadastroProfessor;

import ifpr.pgua.eic.trabalhosemestral.telas.JanelaListaAlunosMatriculados;


import ifpr.pgua.eic.trabalhosemestral.telas.Matricula;
import ifpr.pgua.eic.trabalhosemestral.telas.JanelaPrincipal;
import ifpr.pgua.eic.trabalhosemestral.telas.Lista;
import ifpr.pgua.eic.trabalhosemestral.utils.BaseAppNavigator;
import ifpr.pgua.eic.trabalhosemestral.utils.ScreenRegistryFXML;

public class App extends BaseAppNavigator {

    //Objeto centralizado para o estacionamento
    private Escola escola;

    //método utilizado para inicializar os outros objetos
    @Override
    public void init() throws Exception, IOException, ClassNotFoundException {
        super.init();


        escola = new Escola("Escola","111-2233");
        escola.criaFakes();

        escola.carregarArquivosBin();
        

    }

    @Override
    public void stop() throws Exception {
        super.stop();

        escola.salvarArquivoBin();
        

    }




    //indica qual é a tela inicial
    @Override
    public String getHome() {
        return "PRINCIPAL";
    }

    //título da aplicação
    @Override
    public String getAppTitle() {
        return "Escola";
    }

    //registro de todas as telas da aplicação
    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "fxml/principal.fxml", o->new JanelaPrincipal()));
        registraTela("CADASTRO ALUNO", new ScreenRegistryFXML(App.class, "fxml/cadastrarAluno.fxml", o->new CadastroAluno(escola)));
        registraTela("CADASTRO PROFESSOR", new ScreenRegistryFXML(App.class, "fxml/cadastrarProfessor.fxml", o->new CadastroProfessor(escola)));
        registraTela("CADASTRO CURSO", new ScreenRegistryFXML(App.class, "fxml/cadastrarCurso.fxml", o->new CadastroCurso(escola)));
        registraTela("MATRICULA", new ScreenRegistryFXML(App.class, "fxml/matricula.fxml", o->new Matricula(escola)));
        registraTela("LISTAS", new ScreenRegistryFXML(App.class, "fxml/lista.fxml", o->new Lista(escola)));
        registraTela("LISTAS MATRICULADOS", new ScreenRegistryFXML(App.class, "fxml/listaAlunosMatriculados.fxml", o->new JanelaListaAlunosMatriculados(escola)));

        
       
    }

    

}
