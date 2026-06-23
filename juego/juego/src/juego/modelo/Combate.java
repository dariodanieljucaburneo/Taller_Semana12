package juego.modelo;

import java.util.Random;

public class Combate {
    private Random rand = new Random();

    public Personaje pelear(Personaje p1, Personaje p2) {

        System.out.println("\n--- COMBATE ---");
        System.out.println(p1);
        System.out.println(p2);

        // (Mantenemos tu lógica de validación inicial intacta)
        if (p1.getTipo().equals(p2.getTipo()) && p1.getNivel() == p2.getNivel()) {
            System.out.println("EMPATE: mismo tipo y mismo nivel");
            return null;
        }

        while (p1.getVida() > 0 && p2.getVida() > 0) {
            
            System.out.println("\n--- Turno de " + p1.getNombre() + " ---");
            // RETO: Verificar estados antes de atacar
            if (p1.procesarTurno()) {
                int d1 = p1.atacar();
                System.out.println(p1.getNombre() + " ataca con " + d1);
                p2.defender(d1);
                provocarEstadoAleatorio(p2); // Añade dinamismo al combate
            }

            if (p2.getVida() <= 0) {
                System.out.println("☠️ " + p2.getNombre() + " murió");
                p1.subirNivel(); // ¡Sube de nivel al ganar como pide el enunciado!
                return p1;
            }

            System.out.println("\n--- Turno de " + p2.getNombre() + " ---");
            // RETO: Verificar estados antes de atacar
            if (p2.procesarTurno()) {
                int d2 = p2.atacar();
                System.out.println(p2.getNombre() + " ataca con " + d2);
                p1.defender(d2);
                provocarEstadoAleatorio(p1);
            }

            if (p1.getVida() <= 0) {
                System.out.println("☠️ " + p1.getNombre() + " murió");
                p2.subirNivel(); // ¡Sube de nivel al ganar!
                return p2;
            }
        }
        return null;
    }

    // Método auxiliar para simular la obtención de estados
    private void provocarEstadoAleatorio(Personaje objetivo) {
        int chance = rand.nextInt(100);
        if (chance < 25) { // 25% de probabilidad de recibir un estado al ser golpeado
            int tipoEstado = rand.nextInt(3);
            switch (tipoEstado) {
                case 0 -> objetivo.agregarEstado(new Envenenado(3));
                case 1 -> objetivo.agregarEstado(new Congelado(1));
                case 2 -> objetivo.agregarEstado(new AumentarFuerza(2));
            }
        }
    }
}