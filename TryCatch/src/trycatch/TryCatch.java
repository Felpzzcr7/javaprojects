/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trycatch;

/**
 *
 * @author CG3040224
 */
public class TryCatch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Veiculo v = new Veiculo();
        
        try{
            v.acelerar(20);
            v.acelerar(20);
            v.acelerar(20);
            v.acelerar(20);
            v.acelerar(20);
            v.acelerar(20);
            v.acelerar(20);
            v.acelerar(20);
            
        }
        catch(VelocidadeMaximaException e){
            System.out.println(e.getMessage());
            System.out.println("resenha");
        }
        
        
    }
}
