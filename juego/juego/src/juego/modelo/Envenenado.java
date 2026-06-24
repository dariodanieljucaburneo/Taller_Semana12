package juego.modelo;

public class Envenenado implements IEstadoAlterado {
    private int turnosRestantes;
    private final int danioPorTurno = 5;

    public Envenenado(int turnos) {
        this.turnosRestantes = turnos;
    }

    @Override
    public String getNombre() { return "Envenenado"; }

    @Override
    public void aplicarEfecto(Personaje p) {
        p.setVida(p.getVida() - danioPorTurno);
        System.out.println("-> [EFECTO] " + p.getNombre() + " sufre " + danioPorTurno + " puntos de dano por Veneno.");
    }

    @Override
    public boolean estaActivo() { return turnosRestantes > 0; }

    @Override
    public void reducirTurno() { turnosRestantes--; }

    @Override
    public boolean puedeAtacar() { return true; }
}
