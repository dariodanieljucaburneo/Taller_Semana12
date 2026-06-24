package juego.modelo;

public class Combate {

    public Personaje pelear(Personaje p1, Personaje p2) {

        System.out.println("\n--- COMBATE ---");
        System.out.println(p1);
        System.out.println(p2);

        if (p1.getTipo().equals(p2.getTipo())
                && p1.getNivel() == p2.getNivel()) {

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

            System.out.println("\n--- ESTADO ACTUAL ---");

            String estado1 = (p1.getCooldown() == 0) ? "HABILIDAD CARGADA" : "HABILIDAD EN ESPERA";
            String estado2 = (p2.getCooldown() == 0) ? "HABILIDAD CARGADA" : "HABILIDAD EN ESPERA";

            System.out.println(p1.getNombre() + " | Energia: " + p1.getEnergia() + " | " + estado1);
            System.out.println(p2.getNombre() + " | Energia: " + p2.getEnergia() + " | " + estado2);


            int d1;
            try {
                if (p1.getCooldown() == 0) {
                    d1 = p1.usarHabilidadEspecial();
                    System.out.println(p1.getNombre() + " usa habilidad especial con " + d1);
                } else {
                    d1 = p1.atacar();
                    System.out.println(p1.getNombre() + " ataca con " + d1);
                }
            } catch (Exception e) {
                d1 = p1.atacar();
                System.out.println(p1.getNombre() + " no pudo usar habilidad: " + e.getMessage());
            }

            p2.defender(d1);
            System.out.println("Vida restante de " + p2.getNombre() + ": " + p2.getVida());

            if (p2.getVida() <= 0) {
                System.out.println(p2.getNombre() + " murio");
                return p1;
            }

 
            int d2;
            try {
                if (p2.getCooldown() == 0) {
                    d2 = p2.usarHabilidadEspecial();
                    System.out.println(p2.getNombre() + " usa habilidad especial con " + d2);
                } else {
                    d2 = p2.atacar();
                    System.out.println(p2.getNombre() + " ataca con " + d2);
                }
            } catch (Exception e) {
                d2 = p2.atacar();
                System.out.println(p2.getNombre() + " no pudo usar habilidad: " + e.getMessage());
            }

            p1.defender(d2);
            System.out.println("Vida restante de " + p1.getNombre() + ": " + p1.getVida());

            if (p1.getVida() <= 0) {
                System.out.println(p1.getNombre() + " murio");
                return p2;
            }

            p1.reducirCooldown();
            p2.reducirCooldown();

      
            System.out.println("Estado cooldown actualizado:");
            estado1 = (p1.getCooldown() == 0) ? "HABILIDAD CARGADA" : "HABILIDAD EN ESPERA";
            estado2 = (p2.getCooldown() == 0) ? "HABILIDAD CARGADA" : "HABILIDAD EN ESPERA";

            System.out.println(p1.getNombre() + " -> " + estado1);
            System.out.println(p2.getNombre() + " -> " + estado2);
        }

        return null;
    }
}
