package juego.modelo;

import java.util.Random;

public class Mago extends Personaje {
    
    public Mago(String nombre) {
        this(nombre, 90, 20, 5, 1, 
            new Objeto[]{
                new Arma("Baston", 50),
                new Arma("Varita", 15),
                new Armadura("Toga", 5),
                new Armadura("Tunica", 20)
            }[new Random().nextInt(4)]
        );
    }

    
    private Mago(String nombre, int vida, int ataque, int defensa, int nivel, Objeto objetoAleatorio) {
        super(nombre, vida, ataque, defensa, nivel, "Mago", objetoAleatorio);
    }

    public int atacar() {
        return ataque + 10;
    }
}
