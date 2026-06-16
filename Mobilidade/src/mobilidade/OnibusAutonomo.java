/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobilidade;

/**
 *
 * @author CG3040224
 */
public class OnibusAutonomo extends Veiculo implements Autonomo {

    public OnibusAutonomo(String id, double velocidade) {
        super(id, velocidade);
    }

    @Override
    void mover() {
        System.out.println("Onibus se maxendo ");
    }

    @Override
    public void dirigirSozinho() {
        System.out.println("Andando sozinho");
    }
    
}
