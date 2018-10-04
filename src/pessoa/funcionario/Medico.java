package pessoa.funcionario;

public class Medico extends Funcionario {
    private String crm;

    public Medico(String nome_, String email_, String telefone_, String cpf_, double salario_, String crm){
        super(nome_, email_, telefone_,cpf_ , salario_, "Medico");
        this.crm = crm;
    }

    public String obterCrm(){
        return this.crm;
    }

    public void mudarCrm(String crm_){
        this.crm = crm_;
    }

    @Override
    public String paraString(){
        String parcial;
        parcial = super.paraString() + ", crm: " + this.obterCrm();
        return parcial;
    }
    public String paraString1(){
        String parcial;
        parcial = super.paraString1 ()+this.crm+" ";
        return parcial;
    }
}
