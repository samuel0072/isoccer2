package pessoa.socio;
import pessoa.*;

public class SocioTorcedor extends Pessoa{
    private String endereco;
    private double contribuicao;
    private boolean adimplente;
    private String tipo;

    public SocioTorcedor(String nome_, String email_, String telefone_, String cpf_, String endereco_, double contribuicao_, String tipo_){
        super(nome_, email_, telefone_, cpf_);
        this.endereco = endereco_;
        if(contribuicao_ > 0){
            this.contribuicao = contribuicao_;
        }
        else{
                System.out.println("Contribuição deve ser maior que 0");
        }
        this.adimplente = true;
        this.tipo = tipo_;
    }

    public void mudarEndereco(String endereco_){
        this.endereco = endereco_;
    }

    public void mudarContribuicao(Double contribuicao_){
        if(contribuicao_ > 0){
            this.contribuicao = contribuicao_;
        }
        else{
            System.out.println("Contribuição deve ser maior que 0");
        }
    }

    public void mudarAdimplente(boolean adimplente_){
        this.adimplente = adimplente_;
    }

    public void mudarTipo(String novoTipo){
        this.tipo = novoTipo;
    }

    public String obterEndereco(){
        return this.endereco;
    }

    public double obterContribuicao(){
        return this.contribuicao;
    }

    public boolean obterAdpl(){
        return this.adimplente;
    }

    public String obterTipo(){
        return this.tipo;
    }

    @Override
    public String paraString(){
        String parcial;
        parcial = super.paraString () + ",\tendereco: "+ this.obterEndereco()+",\tcontribuicao: "+this.obterContribuicao ()+(this.obterAdpl () == true?",\tEsta adimplente":",\tNao esta adimplente");
        return parcial;
    }

    public String paraString1(){
        String parcial;
        parcial = super.paraString1()+this.endereco+" "+(int)this.contribuicao+" "+(this.adimplente?"1 ": "0 ");
        return parcial;
    }

}