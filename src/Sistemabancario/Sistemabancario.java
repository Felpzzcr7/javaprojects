import Sistemabancario.Conta;

import java.util.Scanner;

public static void main(String[] args) {
    Conta p1 = new Conta("silvia", 1000);

    Scanner teclado= new Scanner(System.in);

    System.out.println("BOM DIA "+p1.getNome()+ " o que voce gostaria de fazer? \n aperte: \n 1 para saque \n 2 para deposito \n 3 para ver o seu saldo \n 0 sair");
    int escolha = teclado.nextInt();

    while ( escolha != 0){

        if(escolha == 1) {
            System.out.println("quanto voce quer sacar?");
            double saque = teclado.nextDouble();
            p1.setSaque(saque);
            p1.sacar();
        }

        else if(escolha == 2){
            System.out.println("quanto voce quer depositar?");
            double deposito = teclado.nextDouble();
            p1.setDeposito(deposito);
            p1.depositar();

        }

        else if(escolha==3) {
            p1.exibeSaldo();
        }

        else
            System.out.println("escolha invalida, selecione uma OPCAO existente\n");

        System.out.println("o que voce quer fazer agora? \n aperte: \n 1 para saque \n 2 para deposito \n 3 para ver o seu saldo \n 0 sair");
        escolha = teclado.nextInt();
    }
}