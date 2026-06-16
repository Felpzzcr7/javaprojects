/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mobilidade;

import java.util.ArrayList;

/**
 *
 * @author CG3040224
 */
public class Mobilidade {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ArrayList<Veiculo> v = new ArrayList<>(); 
        
        v.add(new CarroEletrico("1",200, 20));
        v.add(new Patinete("2", 20, 50));
        v.add(new OnibusAutonomo("3", 80));
        
       for (Veiculo veiculo : v) {
            veiculo.mover();
            veiculo.exibirInfo();
            if( veiculo instanceof Compartilhavel){
               double preco= ((Compartilhavel) veiculo).calcularCusto(10);
                
                System.out.println("valor da corrida " + preco);        
            }
            if(veiculo instanceof Autonomo){
                ((Autonomo) veiculo).dirigirSozinho();
            }
            
            if(veiculo instanceof Eletrico){
                
                Eletrico eletrico = (Eletrico) veiculo;

              if (eletrico.porcentagem() <= 25) {
            System.out.println("Bateria baixa! Precisa carregar.");
      
                    }
                    
            }
            
            System.out.println("--------------------------------------------------------------------------");
        }
        
    }
    
}
