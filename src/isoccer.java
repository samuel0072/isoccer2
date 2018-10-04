import java.io.IOException;
import java.util.Scanner;

import pessoa.funcionario.*;

import pessoa.*;

public class isoccer {
    static Administrador adm = new Administrador (100100 );

    static Scanner leitor = new Scanner ( System.in );

    public static void main(String[] args) throws IOException {
        while (!adm.entrar ()) {
            limpar ();
        }
        //adm.carragarDados ();
        System.out.println("\t\t------------------------------------------------\n\n\n\n\n\n\n\n\n\n\n\n\t\t------------------------------------------");
        menu ();
    }

    //Auxiliares
    public static void limpar() {
        for (int i = 0; i < 100; i++) {
            System.out.println ();
        }
    }

    public static void menu() throws IOException {
        int d = 0;

        while (d <= 0 || d > 9) {
            limpar ();
            System.out.println ( "\t\t--------------------------Bem vindo-----------------------------" );
            System.out.println ( "\t\t|O que deseja fazer?                                            |" );
            System.out.println ( "\t\t|1\tAdicionar um funcionario                                    |" );
            System.out.println ( "\t\t|2\tAdicionar um socio torcedor                                 |" );
            System.out.println ( "\t\t|3\tAdicionar um recurso                                        |" );
            System.out.println ( "\t\t|4\tGerir um funcionario                                        |" );
            System.out.println ( "\t\t|5\tGerir um recurso                                            |" );
            System.out.println ( "\t\t|6\tGerir um socio-torcedor                                     |" );
            System.out.println ( "\t\t|7\tGerar um relatorio geral                                    |" );
            System.out.println ( "\t\t|8\tGerar um relatorio mais especifico                          |" );
            System.out.println ( "\t\t|9\tsair                                                        |" );
            d = adm.lerNumero ();
            System.out.println ( "\t\t-----------------------------------------------------------------" );
        }
    }
}
