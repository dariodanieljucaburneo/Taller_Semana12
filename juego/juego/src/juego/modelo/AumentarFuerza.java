package juego.modelo;

public class AumentarFuerza implements IEstadoAlterado {
    private int turnosRestantes;
    private final int bonoAtaque = 6;
    private boolean aplicado = false;

    public AumentarFuerza(int turnos) {
        this.turnosRestantes = turnos;
    }

    @Override
    public String getNombre() { return "Aumentar Fuerza"; }

    @Override
    public void aplicarEfecto(Personaje p) {
        if (!aplicado) {
            p.setAtaque(p.getAtaque() + bonoAtaque);
            aplicado = true;
            System.out.println("-> [EFECTO] La fuerza de " + p.getNombre() + " aumenta temporalmente +" + bonoAtaque + "!");
        }
    }

    @Override
    public boolean estaActivo() { 
        return turnosRestantes > 0; 
    }

    @Override
    public void reducirTurno() { 
        turnosRestantes--; 
    }

    @Override
    public boolean puedeAtacar() { return true; }
    
    public void limpiarEfecto(Personaje p) {
        if (aplicado) {
            p.setAtaque(p.getAtaque() - bonoAtaque);
        }
    }
}
