package juego.modelo;

public class Arquero extends Personaje {

    public Arquero(String nombre) {
        super(nombre, 90, 18, 8, 1, "Arquero");
    }

    public int atacar() {
        return ataque + 7;
    }
}