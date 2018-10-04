package pessoa.funcionario;
import pessoa.*;
import java.util.Scanner;

public class Funcionario extends Pessoa{
    private double salario;
    private String cargo;
    private String descricao;

    public Funcionario(String nome_, String email_, String telefone_, String cpf_, double salario_, String cargo_){
        super(nome_, email_, telefone_,cpf_ );
        if(salario_ > 0){
            this.salario = salario_;
        }
        else{
            System.out.println("Salario tem que ser maior que 0");
        }
        this.cargo = cargo_;
    }

    public void mudarSalario(double salario_){
        if(salario > 0){
            this.salario = salario;
        }
        else{
            System.out.println("Salario tem que ser maior que 0");
        }
    }

    public void mudarCargo(String cargo){
        this.cargo = cargo;
    }

    public double obterSalario(){
        return this.salario;
    }

    public String obterCargo(){
        return this.cargo;
    }

    @Override
    public String paraString(){
        String parcial;
        parcial = super.paraString()+", cargo: "+this.obterCargo()+", salario:"+this.obterSalario();
        return parcial;
    }

    @Override
    public String paraString1(){
        String parcial;
        parcial = super.paraString1()+(int)this.salario+" "+this.cargo+" ";
        return parcial;
    }

    public void mudarInfo(){
        Scanner e = new Scanner ( System.in );
        e.next();
        System.out.println("Informe uma descricao sobre o funcionario. Ex.: 'Joga 2 jogos por segundo'");
        this.descricao = e.nextLine ();

    }
}
