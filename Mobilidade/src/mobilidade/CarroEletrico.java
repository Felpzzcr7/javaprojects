/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobilidade;

/**
 *
 * @author CG3040224
 */
public class CarroEletrico extends Veiculo implements Eletrico, Compartilhavel
  {
    int bateria;
    
    public CarroEletrico(String id, double velocidade, int bateria) {
        this.bateria= bateria;
        super(id, velocidade);
    }

    @Override
    void mover() {
        System.out.println("Carro eletrico se maxendo");
    }

    @Override
    public void carregarBateria() {
        System.out.println("bateria carregando");

    }

    @Override
    public double calcularCusto(double distancia) {
        double custo= distancia* 2.5;
      
        return custo;
    }

      @Override
    public int porcentagem() {
        return bateria;
    }
        
    
    
}
