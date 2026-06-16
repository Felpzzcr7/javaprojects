/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prova;

/**
 *
 * @author CG3040224
 */
public class Carro extends Veiculo{

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    int portas;
    public Carro(int id, int ano, String modelo, String marca, int portas) {
        super(id, ano, modelo, marca);
        this.portas= portas;
    }
 
    @Override
    public void exibirInfo(){
        System.out.println("marca: " + marca);
        System.out.println("modelo: " + modelo);
        System.out.println("ano: " + ano);
        System.out.println("id: " + id);
        System.out.println("quantidade de portas: "+ portas+ "\n\n");
        
        
    }
    
}
