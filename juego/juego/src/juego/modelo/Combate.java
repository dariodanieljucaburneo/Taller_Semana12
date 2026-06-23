package juego.modelo;

public class Combate {

    public Personaje pelear(Personaje p1, Personaje p2) {

        System.out.println("\n--- COMBATE ---");
        System.out.println(p1);
        System.out.println(p2);

        if (p1.getTipo().equals(p2.getTipo()) &&
            p1.getNivel() == p2.getNivel()) {

            System.out.println("EMPATE: mismo tipo y mismo nivel");
            return null;
        }

        if (p1.getNivel() == p2.getNivel()) {

            if (p1.atacar() > p2.atacar()) {
                return p1;
            } else if (p2.atacar() > p1.atacar()) {
                return p2;
            }
        }

        while (p1.getVida() > 0 && p2.getVida() > 0) {

            int d1 = p1.atacar();
            System.out.println(p1.getNombre() + " ataca con " + d1);
            p2.defender(d1);

            if (p2.getVida() <= 0) {
                System.out.println(p2.getNombre() + " murió");
                return p1;
            }

            int d2 = p2.atacar();
            System.out.println(p2.getNombre() + " ataca con " + d2);
            p1.defender(d2);

            if (p1.getVida() <= 0) {
                System.out.println(p1.getNombre() + " murió");
                return p2;
            }
        }

        return null;
    }
}