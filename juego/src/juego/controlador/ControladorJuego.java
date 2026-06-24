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

            System.out.println("\n=======================================");
            System.out.println("==========    COMBATE " + i + "    ==========");
            System.out.println("=======================================");

            Personaje p1, p2;

            do {
                p1 = personajes[rand.nextInt(personajes.length)];
                p2 = personajes[rand.nextInt(personajes.length)];
            } while (p1 == p2);

            p1.resetearEstado();
            p2.resetearEstado();

            // Forzamos un estado inicial en el primer combate para la demostración docente
            if (i == 1) {
                p1.agregarEstado(new Envenenado(2));
                p2.agregarEstado(new Congelado(1));
            }

            Personaje ganador = combate.pelear(p1, p2);

            if (ganador == null) {
                System.out.println("\nRESULTADO FINAL: EMPATE");
            } else {
                System.out.println("\nRESULTADO FINAL: GANADOR -> " + ganador.getNombre() + " (Ahora es Nivel " + ganador.getNivel() + ")");
            }
        }
    }
}
