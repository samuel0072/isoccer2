package pessoa.funcionario;

public class Motorista extends Funcionario {
    private String numHab;

    public Motorista(String nome_, String email_, String telefone_, String cpf_, double salario_, String numHab_){
        super(nome_, email_, telefone_, cpf_, salario_, "Motorista");
        this.numHab = numHab_;
    }

    public void mudarHab(String novaHab){
        this.numHab = novaHab;
    }

    public String obterHab(){
        return this.numHab;
    }

    @Override
    public String paraString(){
        String parcial;
        parcial = super.paraString()+"Habilitacao: "+this.obterHab()+" ";
        return parcial;
    }

    @Override
    public String paraString1(){
        String parcial;
        parcial = super.paraString()+this.obterHab()+" ";
        return parcial;
    }
}
