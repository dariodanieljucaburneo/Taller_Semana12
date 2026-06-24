package juego.modelo;

import java.util.Random;

public class Arquero extends Personaje {

    public Arquero(String nombre) {
        this(nombre, 95, 20, 5, 1, 
            new Objeto[]{
                new Arma("Arco Corto", 15),
                new Arma("Arco Largo", 45),
                new Armadura("Capucha de cuero", 10),
                new Armadura("Chaqueta de caza", 40)
            }[new Random().nextInt(4)]
        );
    }

    private Arquero(String nombre, int vida, int ataque, int defensa, int nivel, Objeto objetoAleatorio) {
        super(nombre, vida, ataque, defensa, nivel, "Arquero", objetoAleatorio);
    }

    public int atacar() {
        return ataque + 7;
    }
}
