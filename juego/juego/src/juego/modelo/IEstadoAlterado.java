package juego.modelo;

public interface IEstadoAlterado {
    String getNombre();
    void aplicarEfecto(Personaje personaje);
    boolean estaActivo();
    void reducirTurno();
    boolean puedeAtacar();
}
