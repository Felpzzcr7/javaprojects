/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author CG3040224
 */
public class SistemaVeiculos {
    Scanner teclado = new Scanner(System.in);
    ArrayList<Carro> carros = new ArrayList <>();
    ArrayList<Moto> motos = new ArrayList <>();
    
    
    public void cadastrarCarro(int id, int ano, String modelo, String marca, int portas){
       carros.add(new Carro(id, ano, modelo, marca, portas));
    }
    
    public void cadastrarMoto(int id, int ano, String modelo, String marca, int cilindradas){
       motos.add(new Moto(id, ano, modelo, marca, cilindradas));
    }
    
    public void listarCarros(){
        for(Carro c : carros){
            c.exibirInfo();
        }
    }
     public void listarMotos(){
        for(Moto m : motos){
            m.exibirInfo();
                    }
    }
     
    public void buscarCarro(int id){
       if(carros.size()>0){
        for(Carro c : carros){
            if(c.id == id ){
                c.exibirInfo();
            }
            else
                System.out.println("id nao encontrado");
        }
       }
       else
            System.out.println("nenhum carro cadastrado");
    }
    
    public void buscarMoto (int id){
        if(motos.size()>0){
            for(Moto m : motos){
              if(m.id == id ){
                  m.exibirInfo();
              }
              else
                 System.out.println("id nao encontrado");
            }
        }
        else
            System.out.println("nehuma moto cadastrada");
    
    }
    
    public void atualizarCarro(int id, int ano, String modelo, String marca, int portas){
            if(carros.size()>0){
        for(Carro c : carros){
            if(c.id == id ){
               c.ano=ano;
               c.marca= marca;
               c.modelo=modelo;
               c.portas=portas;
            }
            else
                System.out.println("id nao encontrado");
        }
       }
       else
            System.out.println("nenhum carro cadastrado");
        }
    
    public void atualizarMoto(int id, int ano, String modelo, String marca, int cilindradas){
        if(carros.size()>0){
        for(Moto m : motos){
            if(m.id == id ){
               m.ano=ano;
               m.marca= marca;
               m.modelo=modelo;
               m.cilindradas=cilindradas;
            }
            else
                System.out.println("id nao encontrado");
        }
       }
       else
            System.out.println("nenhuma moto cadastrada");
        }
        
    public void removerCarro(int id){
           if(carros.size()>0){
        for(Carro c : carros){
            if(c.id == id ){
               carros.remove(c);
            }
            else
                System.out.println("id nao encontrado");
        }
       }
       else
            System.out.println("nenhum carro cadastrado");
    }
    
   public void removerMoto(int id){
               if(motos.size()>0){
            for(Moto m : motos){
              if(m.id == id ){
                  motos.remove(m);
              }
              else
                 System.out.println("id nao encontrado");
            }
        }
        else
            System.out.println("nehuma moto cadastrada");
    
    }
   
}
