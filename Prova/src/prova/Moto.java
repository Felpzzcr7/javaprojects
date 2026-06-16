/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova;

public class Moto extends Veiculo {
    int cilindradas;

    public Moto(int id, int ano, String modelo, String marca, int cilindradas) {
        super(id, ano, modelo, marca);
        this.cilindradas= cilindradas;
    }
    
    @Override
    public void exibirInfo(){
        System.out.println("marca: " + marca);
        System.out.println("modelo: " + modelo);
        System.out.println("ano: " + ano);
        System.out.println("id: " + id);
        System.out.println("cilindradas: " + cilindradas+ "\n\n");
    }
}
