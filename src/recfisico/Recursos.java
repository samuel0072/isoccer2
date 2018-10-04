package recfisico;

public class Recursos {
    private String tipo;
    private boolean disponivel;

    public Recursos(String tipo_, boolean disp){
        this.tipo = tipo_;
        this.disponivel = disp;
    }

    public void mudarTipo(String tipo){
        this.tipo = tipo;
    }

    public void mudarDisponivel(boolean disp){
        this.disponivel = disp;
    }

    public String mudarTipo(){
        return this.tipo;
    }

    public boolean mudarDisponivel(){
        return this.disponivel;
    }

    public String paraString(){
        String parcial;

        parcial = this.tipo+", "+(this.mudarDisponivel()?"Recurso disponivel":"Recurso insdisponivel");
        return parcial;
    }

    public String paraString1(){
        String parcial;
        parcial = (this.disponivel?"1 ": "0 ");
        return parcial;
    }


}
