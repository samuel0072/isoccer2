package recfisico;

public class Centro extends Recursos {
    private int dormitorios;


    public Centro(int dormitorios_, boolean disp){
        super("Centro", disp);
        if(dormitorios_ > 0){
            this.dormitorios = dormitorios_;
        }
        else{
            System.out.println("Nao sao permitidos valores negativos!");
        }
    }

    public void mudarDormitorios(int dormitorios_){
        if(dormitorios_ > 0){
            this.dormitorios = dormitorios_;
        }
        else{
            System.out.println("Nao sao permitidos valores negativos!");
        }
    }

    public int obterDormitorios(){
        return this.dormitorios;
    }

    @Override
    public String paraString(){
        String parcial;

        parcial = super.paraString ()+", Quantidade de dormitorios: "+this.obterDormitorios ();

        return parcial;
    }
    public String paraString1(){
        String parcial;
        parcial = super.paraString1 ()+this.dormitorios+" ";
        return parcial;
    }
}
