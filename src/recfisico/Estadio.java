package recfisico;

public class Estadio extends Recursos {

    private int capacidade;
    private int banheiros;
    private int lanchonetes;

    public Estadio(int capacidade_, int banheiros_, int lanchonetes_, boolean disp){
        super("Estadio", disp);
        if(capacidade_ > 0 && banheiros_ > 0 && lanchonetes_ > 0){
            this.capacidade = capacidade_;
            this.banheiros  = banheiros_;
            this.lanchonetes = lanchonetes_;
        }
        else{
            System.out.println("Nao sao permitidos valores negativos!");
        }
    }

    public void mudarCapacidade(int capacidade_){
        if(capacidade_ > 0){
            this.capacidade = capacidade_;
        }
        else{
            System.out.println("Nao sao permitidos valores negativos!");
        }
    }

    public void mudarBanheiros(int banheiros_){
        if(banheiros_ >0){
            this.banheiros = banheiros_;
        }
        else{
            System.out.println("Nao sao permitidos valores negativos!");
        }
    }

    public void mudarLanchonetes(int lanchonetes_){
        if(lanchonetes_ > 0){
            this.lanchonetes = lanchonetes_;
        }
        else{
            System.out.println("Nao sao permitidos valores negativos!");
        }
    }

    public int obterCapacidade(){
        return this.capacidade;
    }

    public int obterBanheiros(){
        return this.banheiros;
    }

    public int obterLanchonetes(){
        return this.lanchonetes;
    }

    @Override
    public String paraString(){
        String parcial;

        parcial = super.paraString ()+", Capacidade: "+this.obterCapacidade()+", Banheiros: "+this.obterBanheiros()+", Lanchonetes: "+this.obterLanchonetes();

        return parcial;
    }

    public String paraString1(){
        String parcial;
        parcial = super.paraString1 ()+this.capacidade+" "+this.banheiros+" "+this.lanchonetes+" ";
        return parcial;
    }
}
