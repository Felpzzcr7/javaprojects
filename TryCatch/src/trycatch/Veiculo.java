/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package trycatch;

/**
 *
 * @author CG3040224
 */
public class Veiculo {
    int velocidadeAtual;
    
    public void acelerar(int valor)throws VelocidadeMaximaException {
        velocidadeAtual+=valor;
        
        if(velocidadeAtual >120){
            throw new VelocidadeMaximaException("Velocidade excedida");
        }
        
        System.out.println("velocidade atual: "+ velocidadeAtual + " km/h");
    }
}
