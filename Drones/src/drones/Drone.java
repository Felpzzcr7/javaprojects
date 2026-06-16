package drones;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */



public class Drone {
    int id, capacidadeCarga, autonomiaKm, velocidade;
    String modelo;
    boolean disponivel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(int capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
    }

    public int getAutonomiaKm() {
        return autonomiaKm;
    }

    public void setAutonomiaKm(int autonomiaKm) {
        this.autonomiaKm = autonomiaKm;
    }
    

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
      public Drone(int id, int capacidadeCarga, int autonomiaKm, String modelo, boolean disponivel, int velocidade) {
        this.id = id;
        this.capacidadeCarga = capacidadeCarga;
        this.autonomiaKm = autonomiaKm;
        this.modelo = modelo;
        this.disponivel = disponivel;
        this.velocidade = velocidade;
    }
    
public void exibirInformacoes(){
    System.out.println(id);
    System.out.println(capacidadeCarga);
    System.out.println(autonomiaKm);
    System.out.println(modelo);
    System.out.println(disponivel);
    System.out.println(velocidade);
}

public void marcarDisponivel(){
    this.disponivel=true;
    
}
public void marcarOcupado(){
    this.disponivel= false;
}
    
}
