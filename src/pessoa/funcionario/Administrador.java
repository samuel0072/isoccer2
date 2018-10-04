package pessoa.funcionario;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import pessoa.socio.*;
import pessoa.Pessoa;
import recfisico.*;


public class Administrador extends Funcionario {
    private String login = "admin";
    private String senha = "senha";

    protected Funcionario presidente;

    private ArrayList<Funcionario> funcs    = new ArrayList<Funcionario>();
    private ArrayList<Medico> med           = new ArrayList<Medico>();
    private ArrayList<Motorista> moto       = new ArrayList<Motorista>();
    private ArrayList<SocioTorcedor> socios = new ArrayList<SocioTorcedor>();
    private ArrayList<Jogador> jogadores    = new ArrayList <Jogador>();
    private Centro ct;
    private Estadio est;
    private ArrayList<Recursos> onibus = new ArrayList<Recursos>();

    private Scanner leitor =  new Scanner ( System.in);

    public Administrador(double salario_){
        super("", "", "","", salario_, "Administrador");
    }

    private void mudarLogin(String novo_login){
        this.login = novo_login;
    }

    private void mudarSenha(String nova_senha){
        this.senha = nova_senha;
    }

    private String obterLogin(){
        return this.login;
    }

    private String obterSenha(){
        return this.senha;
    }

    public boolean entrar(){
        String l1, s1;
        System.out.println("Digite seu login e senha:");
        System.out.print("login: ");
        l1 = leitor.nextLine ();
        System.out.println("\nSenha: ");
        s1 = leitor.nextLine ();
        return ( l1.equals ( this.obterLogin () ) && s1.equals( this.obterSenha () ));

    }

    @Override
    public String paraString(){
        String parcial;

        parcial = super.paraString()+", Login: "+ this.obterLogin ();
        return parcial;
    }

    //Mostra na tela e grava em dois arquivos .txt o estado atual de todos
    //os funcionarios e recursos fisicos
    public void relatorioGeral() throws IOException {
        try {
            System.out.println("\t\t-------------Estado do Sistema-------------");
            FileWriter arq1 = new FileWriter ( "relatorioRecH.txt" );
            FileWriter arq2 = new FileWriter ( "relatorioRecF.txt" );
            PrintWriter gravarArq = new PrintWriter ( arq1 );
            PrintWriter gravarArq2 = new PrintWriter ( arq2 );


            System.out.println ( "Recursos humanos" );
            if(presidente != null){
                System.out.println ( presidente.paraString () );
                gravarArq.println ( "1\n"+presidente.paraString1());
            }
            else {
                System.out.println("Nao ha presidente");
                gravarArq.println("0");
            }
            gravarArq.println ( funcs.size());
            for (int i = 0; i < funcs.size (); i++) {
                System.out.println ( funcs.get ( i ).paraString());
                gravarArq.println( funcs.get ( i ).paraString1());
            }
            gravarArq.println ( jogadores.size());
            for (int i = 0; i < jogadores.size (); i++) {
                System.out.println ( jogadores.get ( i ).paraString());
                gravarArq.println( jogadores.get ( i ).paraString1());
            }
            gravarArq.println ( med.size());
            for (int i = 0; i < med.size (); i++) {
                System.out.println( med.get ( i ).paraString());
                gravarArq.println( med.get ( i ).paraString1());
            }
            gravarArq.println ( socios.size());
            for (int i = 0; i < socios.size (); i++) {
                System.out.println ( socios.get ( i ).paraString());
                gravarArq.println( socios.get ( i ).paraString1());
            }

            System.out.println ( "\t\t------------------Recursos fisicos-----------------" );
            System.out.println ( ct.paraString () );
            System.out.println (est.paraString ());
            for(int i = 0; i < onibus.size(); i++){
                System.out.println (onibus.get(i).paraString ());
            }
            gravarArq2.println ( ct.paraString1());
            gravarArq2.println ( est.paraString1 ());
            gravarArq2.println(onibus.size());
            for(int i = 0; i < onibus.size(); i++){
                gravarArq2.write ( onibus.get(i).paraString1 ());
            }
            

            gravarArq.close ();
            gravarArq2.close();
            System.out.println("\t\t-----------------------------------");
        }
        catch (FileNotFoundException e){
            System.out.println("ops! Tivemos um problema!");
        }
        finally{
            return;
        }
    }

    //Mostra na tela estado atual de todos os funcionarios
    public void relatorioFuncs(){
        System.out.println("\t\t-------------Estado dos funcionarios-------------");
        if(presidente != null){
                System.out.println ( presidente.paraString () );
            }
        else {
            System.out.println("\t\tNao ha presidente");
        }

        for (int i = 0; i < funcs.size (); i++) {
            System.out.println(funcs.get ( i ).paraString());
        }

        for (int i = 0; i < jogadores.size (); i++) {
            System.out.println(jogadores.get ( i ).paraString());
        }

        for (int i = 0; i < med.size (); i++) {
            System.out.println(med.get ( i ).paraString());
        }

        for (int i = 0; i < socios.size (); i++) {
            System.out.println(socios.get ( i ).paraString());
        }
        for (int i = 0; i < socios.size (); i++) {
            System.out.println(moto.get ( i ).paraString());
        }
        System.out.println("\t\t-------------------------------------------------");
    }

    public void relatorioRecF(){
        System.out.println("\t\t-------------Estado dos recursos fisicos-------------");
        int i;
        System.out.println("\t\t-------------Onibus----------------------------------");
        for(i = 0; i < this.onibus.size(); i++){
            System.out.println(this.onibus.get(i).paraString());    
        }
        System.out.println("\t\t-------------Centro de treinamento-------------------");
        System.out.println(this.ct.paraString()); 
        System.out.println("\t\t-------------Estadio---------------------------------");
        System.out.println(this.est.paraString());     
        System.out.println("\t\t-----------------------------------------------------");
    }

    //Escreve na tela todos os jogadores aptos a jogar
    public void jogadoresAptos(){
        System.out.println("\t\t--------------Jogadores aptos a jogar-----------------");
        for (int i = 0; i < jogadores.size (); i++) {
           if(this.jogadores.get ( i ).obterApto()){
                System.out.println(this.jogadores.get ( i ).paraString());
           }
        }
        System.out.println("\t\t------------------------------------------------------");
    }

    /*public int buscaP(ArrayList alvo, String cpf){

        for(int i = 0; i < alvo.size (); i++){
            if(alvo.get ( i ) instanceof Pessoa ){
                if(((Pessoa) alvo.get(i)).obterCpf ().equals(cpf)){
                    return i;
                }
            }
        }
        return -1;
    }*/

    public int lerNumero(){
        int salario = 0, salario0 = -1;
        while(salario <= 0){
            try{
                salario0 = leitor.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println ("Digite um valor numerico!");
                salario0 = leitor.nextInt();
            }
            finally {
                salario = salario0;
            }
        }
        return salario;
    }

    /*public void carragarDados() throws IOException{
        try{

            this.ct = new Centro ( 1, true );
            this.onibus = new Recursos ( "Onibus", true );
            this.est = new Estadio ( 1, 1, 1, true );

            Scanner recH = new Scanner ( new BufferedReader ( new FileReader (  "relatorioRecH.txt") ) );
            Scanner recF = new Scanner ( new BufferedReader ( new FileReader (  "relatorioRecF.txt") ) );

            String nome, email, telefone, cpf, cargo, tipo, crm, endereco;
            double salario;
            int size, d, d1, d2, d3, d4;

            nome =  recH.next ();
            email = recH.next();
            telefone = recH.next();
            cpf = recH.next();
            salario = recH.nextInt ();
            cargo = recH.next();
            this.presidente = new Funcionario ( nome, email, telefone, cpf, salario, cargo );

            size = recH.nextInt ();

            for(int i = 0; i < size; i++){
                nome =  recH.next ();
                email = recH.next();
                telefone = recH.next();
                cpf = recH.next();
                salario = recH.nextInt ();
                cargo = recH.next();
                this.funcs.add(new Funcionario ( nome, email, telefone, cpf,  salario, cargo));
            }
            size = recH.nextInt ();

            for(int i = 0; i < size; i++){
                nome =  recH.next ();
                email = recH.next();
                telefone = recH.next();
                cpf = recH.next();
                salario = recH.nextInt ();
                cargo = recH.next();
                tipo = recH.next();
                d = recH.nextInt();
                this.jogadores.add(new Jogador(nome, email, telefone, cpf, tipo, d == 1, salario));
            }
            size = recH.nextInt ();
            for(int i = 0; i < size; i++){
                nome =  recH.next ();
                email = recH.next();
                telefone = recH.next();
                cpf = recH.next();
                salario = recH.nextInt ();
                cargo = recH.next();
                crm = recH.next();
                this.med.add(new Medico(nome, email, telefone, cpf, salario, crm));
            }
            size = recH.nextInt ();
            for(int i = 0; i < size; i++){
                nome =  recH.next ();
                email = recH.next();
                telefone = recH.next();
                cpf = recH.next();
                endereco = recH.next();
                salario = recH.nextInt ();
                d = recH.nextInt ();
                this.socios.add(new SocioTorcedor(nome, email, telefone, cpf, endereco, salario));
                int b = this.buscaP ( this.socios, nome );
                SocioTorcedor c = this.socios.get(b);
                c.mudarAdimplente ( d == 1 );
            }
            //nome = recF.next ();

            d1 = recF.nextInt ();
            d2 = recF.nextInt ();

            this.ct.mudarDormitorios ( d2 );
            this.ct.mudarDisponivel ( d1 == 1 );

            //nome = recF.next ();
            d1 = recF.nextInt ();
            d2 = recF.nextInt ();
            d3 = recF.nextInt ();
            d4 = recF.nextInt ();

            this.est.mudarDisponivel( d1 == 1 );
            this.est.mudarCapacidade ( d2 );
            this.est.mudarBanheiros ( d3 );
            this.est.mudarLanchonetes ( d4 );

            //nome = recF.next ();
            d1 = recF.nextInt ();

            this.onibus.mudarDisponivel ( d1 == 1 );

            recH.close ();
            recF.close();
        }
        catch (FileNotFoundException e){
            this.ct = null;
            this.onibus = null;
            this.est = null;
            return;
        }
        finally{
            return;
        }

    }*/

    //Adiciona um funcionario ao sistema
    public void adcFunc(){
        String nome, cpf, telefone, cargo, email, tipo, crm;
        String[] cargos = {"Presidente", "Jogador","Advogado" , "Medico", "Preparador fisico", "Motorista", "Cozinheiro", "Jogador"};
        double salario;
        int d = 0;

        while(d < 1 || d > 8) {

            System.out.println ( "Que tipo de funcionario deseja adicionar?" );
            System.out.println ( "1\tPresidente" );
            System.out.println ( "2\tJogador" );
            System.out.println ( "3\tAdvogado" );
            System.out.println ( "4\tMedico" );
            System.out.println ( "5\tPreparador fisico" );
            System.out.println ( "6\tMotorista" );
            System.out.println ( "7\tCozinheiro" );
            System.out.println ( "8\tJogador" );

            d = this.lerNumero ();
        }

        cargo = cargos[d-1];

        leitor.nextLine();
        System.out.println ("Informe os dados");
        System.out.println ("nome:");
        nome = leitor.nextLine(  );
        System.out.println ("email:");
        email = leitor.nextLine();
        System.out.println ("telefone:");
        telefone = leitor.nextLine();
        System.out.println ("cpf:");
        cpf = leitor.nextLine();
        System.out.println ("salario:");

        salario = (double)lerNumero();
        leitor.nextLine ();

        if(cargo.equals("Presidente")){
            this.presidente = new Funcionario(nome, email, telefone, cpf, salario, cargo);
        }
        else if(cargo.equals("Medico")){
            
            System.out.println ("crm:");
            crm = leitor.nextLine();
            this.med.add(new Medico(nome, email, telefone, cpf, salario, crm));
        }
        else if(cargo.equals("Jogador")){
            
            System.out.println("O jogador está apto para jogar?\ndigite 0 para não e qualquer outra coisa para sim");
            String a  = leitor.next( );

            System.out.println ("posição:\nEx.: Meio-campo");
            tipo = leitor.nextLine(  );

            this.jogadores.add ( new Jogador ( nome, email, telefone, cpf, tipo, a.equals("0"), salario ));
        }
        else if(cargo.equals("Motorista")) {
            
            System.out.println("Digite o numero da habilitacao:");
            String numHab = leitor.nextLine();
            this.moto.add(new Motorista(nome, email, telefone, cpf, salario, numHab));
        }
        else {

            this.funcs.add(new Funcionario(nome, email, telefone, cpf, salario, cargo));
        }

    }
    //Adiciona um socio torcedor ao sistema
    public void adcST(){
        leitor.nextLine();
        String nome, email, endereco, cpf, telefone;
        double contribuicao;
        String[] tipos = {"Elite", "Junior", "Senior"};

        System.out.println ("Informe o nome do Socio:");
        nome = leitor.nextLine();
        System.out.println ("Informe o email:");
        email = leitor.nextLine();
        System.out.println ("Informe o endereco:");
        endereco = leitor.nextLine();
        System.out.println ("Informe o telefone:");
        telefone = leitor.nextLine();
        System.out.println ("Informe o cpf:");
        cpf = leitor.nextLine(  );
        System.out.println ("Informe a contribuicao:");
        contribuicao = (double)lerNumero();

        int escolha = -1;
        while(escolha < 0 || escolha > 3){
            System.out.println("\nTipo de socio:\t1-Elite\n\t2-Junior\n\t3-Senior");
            escolha = this.lerNumero ();
        }

        socios.add( new SocioTorcedor( nome, email, telefone, cpf, endereco, contribuicao, tipos[escolha-1] ));
    }

    //Adiciona um recurso ao sistema
    public void adcRec(){
        String tipo;
        String[] tipos = {"Onibus", "Centro de treinamento", "Estadio"};
        int dormitorios, capacidade, banheiros, lanchonetes, d = 0;
        System.out.println("Que tipo de recurso deseja adicionar?");

        while(d <= 0 || d > 3){
            System.out.println("1\tOnibus");
            System.out.println("2\tCentro de treinamento");
            System.out.println("3\tEstadio");
            d = this.lerNumero ();
        }
        tipo = tipos[d-1];

        leitor.nextLine ();
        System.out.println("Esta disponivel?\n\t1 para sim\n\tQualquer outra coisa para nao");
        String aux = leitor.next ();

        if(tipo.equals("Onibus")){
            this.onibus.add( new Recursos ( tipo,  aux.equals ( "1" )));
        }
        else if(tipo.equals("Centro de treinamento")){
            if(this.ct == null) {
                System.out.println("Quantos dormitorios?");
                dormitorios = this.lerNumero ();
                this.ct = new Centro(dormitorios, aux.equals ( "1" ));
            }
            else {
                System.out.println("Ja existe um centro de treinamento!");
            }

        }
        else {
            if(this.est == null) {
                System.out.println("Informe cada quantidade");
                System.out.print("Capacidade(Quantidade de pessoas): ");
                capacidade = this.lerNumero ();
                System.out.print("Banheiros: ");
                banheiros = this.lerNumero ();
                System.out.println("Lanchonetes: ");
                lanchonetes = this.lerNumero ();
                this.est = new Estadio(capacidade, banheiros, lanchonetes, aux.equals ( "1" ));
            }
            else {
                System.out.println("Ja existe um centro de treinamento!");
            }

        }
    }

    /*public void editarInfo(){
       int d = 0;
       while(d <= 0 || d > 2){
           System.out.println("Digite para editar:\n\t1 Funcionario\n\t2 Socio torcedor");
           d = this.lerNumero ();
       }
       leitor.next ();
       if(d == 1){
           System.out.println("Funcionarios no sistema:");
           this.relatoriofuncs();
           System.out.println("Digite o cpf do funcionario que deseja atualizar alguns dados:");
           String cpf = leitor.nextLine ();
           int i;
           i = this.buscaP()
       }
       else{

       }

   }*/
}
