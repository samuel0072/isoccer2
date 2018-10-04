package pessoa;

public class Pessoa {
    private String nome;
    private String email;
    private String telefone;
    private String cpf;

    public Pessoa(String nome_, String email_, String telefone_, String cpf_){
        this.nome = nome_;
        this.email = email_;
        this.cpf = cpf_;
        this.telefone = telefone_;
    }

    /*Setters*/
    public void mudarNome(String name_){
        this.nome = name_;
    }

    public void mudarEmail(String email_){
        this.email = email_;
    }

    public void mudarTelefone(String phone_){
        this.telefone = phone_;
    }

    public void mudarCpf(String cpf_){
        this.cpf = cpf_;
    }

    /*Getters*/

    public String obterNome(){
        return this.nome;
    }

    public String obterEmail(){
        return this.email;
    }

    public String obterTelefone(){
        return this.telefone;
    }

    public String obterCpf(){
        return this.cpf;
    }

    public String paraString(){
        String parcial;
        parcial = "Nome: "+this.obterNome()+",\tEmail:"+this.obterEmail()+",\tTelefone: "+this.obterTelefone()+",\tCPF: "+this.obterCpf();
        return parcial;
    }

    public String paraString1(){
        String parcial;
        parcial = this.nome +" "+this.email+" "+this.telefone+" "+this.cpf+" ";
        return parcial;
    }
}
