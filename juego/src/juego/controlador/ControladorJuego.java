package juego.controlador;

import juego.modelo.*;
import java.util.Random;

public class ControladorJuego {

    private Combate combate;
    private Random rand;

    public ControladorJuego() {
        combate = new Combate();
        rand = new Random();
    }

    public void run() {

        Personaje[] personajes = {
            new Guerrero("Kratos"),
            new Mago("Gandalf"),
            new Arquero("Legolas"),
            new Guerrero("Ares"),
            new Mago("Merlin"),
            new Arquero("Robin")
        };

        for (int i = 1; i <= 3; i++) {

            System.out.println("\n========== COMBATE " + i + " ==========");

            Personaje p1, p2;

            do {
                p1 = personajes[rand.nextInt(personajes.length)];
                p2 = personajes[rand.nextInt(personajes.length)];
            } while (p1 == p2); 

            Personaje ganador = combate.pelear(p1, p2);

            if (ganador == null) {
                System.out.println("RESULTADO: EMPATE");
            } else {
                System.out.println("GANADOR: " + ganador.getNombre());
            }
        }
    }
}