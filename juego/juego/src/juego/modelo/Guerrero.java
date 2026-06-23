package juego.modelo;

public class Guerrero extends Personaje {

    public Guerrero(String nombre) {
        super(nombre, 100, 15, 10, 1, "Guerrero");
    }

    public int atacar() {
        return ataque + 5;
    }
}