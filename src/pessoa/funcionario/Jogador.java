package pessoa.funcionario;


public class Jogador extends Funcionario{
	String tipo;
	boolean apto;

	public Jogador(String nome_, String email_, String telefone_, String cpf_, String tipo, boolean apto_, double salario_){
		super( nome_,  email_,  telefone_,  cpf_, salario_, "Jogador");
		this.tipo = tipo;
		this.apto = apto_;
	}

	public String obterTipo(){
		return this.tipo;
	}

	public boolean obterApto(){
		return this.apto;
	}

	public void mudarTipo(String tipo){
		this.tipo = tipo;
	}

	public void mudarApto(boolean apto){
		this.apto = apto;
	}

	@Override
	public String paraString(){
		String parcial;
		parcial = super.paraString ()+", posicao: "+this.obterTipo()+((this.obterApto())?", Jogador esta apto para jogar!":"Jogador nao esta apto para jogar!");
		return parcial;
	}

	public String paraString1(){
		String parcial;
		parcial = super.paraString1()+this.tipo+" "+ (this.apto? "1 ": "0 ");
		return parcial;
	}
}
