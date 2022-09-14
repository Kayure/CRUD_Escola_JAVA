package ifpr.pgua.eic.trabalhosemestral.models;

public class Professor extends Pessoa {
   
    private double salario;
    Professor professor;

    public Professor (String cpf, String nome, String email, String telefone, double salario){
        super(cpf, nome, email, telefone);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    @Override
    public String toString() {
        return super.toString()+               
                "\n SALARIO : "+getSalario()+"\n";
    }

    public String paraTexto(){

        return  "NOME:"+getNome()+
                    "CPF:"+professor.getCpf()+
                    "SALARIO:"+getSalario();
                   
    }
}

