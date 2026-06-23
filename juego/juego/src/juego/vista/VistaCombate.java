package juego.vista;

import juego.modelo.Personaje;

public class VistaCombate {

    public void mostrarGanador(Personaje p) {

        if (p == null) {
            System.out.println("Resultado: EMPATE");
        } else {
            System.out.println("GANADOR: " + p.getNombre());
        }
    }
}