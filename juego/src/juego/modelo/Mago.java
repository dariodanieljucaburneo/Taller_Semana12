package juego.modelo;

public class Mago extends Personaje {

    public Mago(String nombre) {
        super(nombre, 80, 20, 5, 1, "Mago");
    }

    public int atacar() {
        return ataque + 10;
    }
}