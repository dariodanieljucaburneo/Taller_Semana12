package juego.modelo;

public class Congelado implements IEstadoAlterado {
    private int turnosRestantes;

    public Congelado(int turnos) {
        this.turnosRestantes = turnos;
    }

    @Override
    public String getNombre() { return "Congelado"; }

    @Override
    public void aplicarEfecto(Personaje p) {
        System.out.println("-> [EFECTO] " + p.getNombre() + " esta congelado y no se movera este turno.");
    }

    @Override
    public boolean estaActivo() { return turnosRestantes > 0; }

    @Override
    public void reducirTurno() { turnosRestantes--; }

    @Override
    public boolean puedeAtacar() { return false; }
}
