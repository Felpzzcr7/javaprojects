/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prova;

import java.util.Scanner;

public class Prova {

    public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
     SistemaVeiculos sistema = new SistemaVeiculos();
     
 System.out.println(
                "1 - Cadastrar Carro\n" +
                "2 - Cadastrar Moto\n" +
                "3 - Listar Carros\n" +
                "4 - Listar Motos\n" +
                "5 - Atualizar Carro\n" +
                "6 - Atualizar Moto\n" +
                "7 - Remover Carro\n" +
                "8 - Remover Moto\n" +
                "0 - Sair");
     int escolha = teclado.nextInt();
        while(escolha !=0){
        
        if(escolha ==1){
            System.out.println("cadastre um id: ");
            int id=teclado.nextInt();
            System.out.println("ano: ");
            int ano=teclado.nextInt();
            teclado.nextLine();
            System.out.println("qual modelo?");
            String modelo=teclado.nextLine();
            System.out.println("quantas portas?: ");
            int portas= teclado.nextInt();
            teclado.nextLine();
            System.out.println("qual marca?");
            String marca=teclado.nextLine();
         
            sistema.cadastrarCarro(id,ano,modelo,marca,portas);
            
        }
        
        if(escolha == 2){
            System.out.println("cadastre um id: ");
            int id=teclado.nextInt();
            System.out.println("ano: ");
            int ano=teclado.nextInt();
            teclado.nextLine();
            System.out.println("qual modelo?");
            String modelo=teclado.nextLine();
            System.out.println("quantas cilindradas?: ");
            int cilindradas= teclado.nextInt();
            teclado.nextLine();
            System.out.println("qual marca?");
            String marca=teclado.nextLine();
            
            sistema.cadastrarMoto(id,ano,modelo,marca,cilindradas);
            
              }
        
        if(escolha==3)
        sistema.listarCarros();
        
        if(escolha==4)
        sistema.listarMotos();
         
         if(escolha==5){
             System.out.println("qual o id do carro que tem que atualizar?:");
            int id=teclado.nextInt();
            System.out.println("ano: ");
            int ano=teclado.nextInt();
            teclado.nextLine();
            System.out.println("qual modelo?");
            String modelo=teclado.nextLine();
            System.out.println("quantas portas?: ");
            int portas= teclado.nextInt();
            teclado.nextLine();
            System.out.println("qual marca?");
            String marca=teclado.nextLine();
             sistema.atualizarCarro(id, ano, modelo, marca, portas);
         }
         
         if(escolha==6){
                     System.out.println("qual o id da moto que tem que atualizar?: ");
            int id=teclado.nextInt();
            System.out.println("ano: ");
            int ano=teclado.nextInt();
            teclado.nextLine();
            System.out.println("qual modelo?");
            String modelo=teclado.nextLine();
            System.out.println("quantas cilindradas?: ");
            int cilindradas= teclado.nextInt();
            teclado.nextLine();
            System.out.println("qual marca?");
            String marca=teclado.nextLine();
            
             sistema.atualizarMoto(id, ano, modelo, marca, cilindradas);
         }
         
         if(escolha==7){
              System.out.println("qual o id do carro que voce quer excluir? ");
             int id=teclado.nextInt();
             sistema.removerCarro(id);
             System.out.println("excluido");
         }
         
         if(escolha==8){
             System.out.println("qual o id da moto que voce quer excluir? ");
             int id=teclado.nextInt();
             sistema.removerMoto(id);
             System.out.println("excluido");
         }
         System.out.println(
                "1 - Cadastrar Carro\n" +
                "2 - Cadastrar Moto\n" +
                "3 - Listar Carros\n" +
                "4 - Listar Motos\n" +
                "5 - Atualizar Carro\n" +
                "6 - Atualizar Moto\n" +
                "7 - Remover Carro\n" +
                "8 - Remover Moto\n" +
                "0 - Sair");
          escolha = teclado.nextInt();
        }
        

    }
    
}
