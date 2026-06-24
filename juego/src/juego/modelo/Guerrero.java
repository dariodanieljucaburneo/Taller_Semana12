package juego.modelo;

import java.util.Random;

public class Guerrero extends Personaje {

    public Guerrero(String nombre) {
       
        this(nombre, 100, 15, 10, 1, 
            new Objeto[]{
                new Arma("Espada corta", 15),
                new Arma("Espada larga", 25),
                new Armadura("Casco", 15),
                new Armadura("Guanteletes", 10)
            }[new Random().nextInt(4)]
        ); 
    }

    
    private Guerrero(String nombre, int vida, int ataque, int defensa, int nivel, Objeto objetoAleatorio) {
        super(nombre, vida, ataque, defensa, nivel, "Guerrero", objetoAleatorio);
    }

    public int atacar() {
        return ataque + 5;
    }
}
