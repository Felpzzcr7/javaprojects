/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobilidade;

/**
 *
 * @author CG3040224
 */
public abstract class Veiculo {
    
String id;
double velocidade;


abstract void mover();

    public Veiculo(String id, double velocidade) {
        this.id = id;
        this.velocidade = velocidade;
    }



public void exibirInfo(){
    System.out.println("id: "+id);
    System.out.println("velocidade maxima: "+velocidade);
}

}
