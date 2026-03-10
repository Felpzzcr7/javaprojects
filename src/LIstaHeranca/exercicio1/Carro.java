package LIstaHeranca.exercicio1;

public class Carro extends Veiculo {

    public Carro(int velocidade){
        super(velocidade);
    }
    public void exibeVelocidade(){
        System.out.println(velocidade+"km/h");
    }
}
