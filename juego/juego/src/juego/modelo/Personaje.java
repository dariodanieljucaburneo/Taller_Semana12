package juego.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Personaje {

    protected String nombre;
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected int nivel;
    protected String tipo; 
    
    // RETO: Gestión de estados activos
    protected List<IEstadoAlterado> estadosActivos;

    public Personaje(String nombre, int vida, int ataque, int defensa, int nivel, String tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nivel = nivel;
        this.tipo = tipo;
        this.estadosActivos = new ArrayList<>();
    }

    public abstract int atacar();

 
    public boolean procesarTurno() {
        boolean puedeAtacar = true;
        
        for (int i = estadosActivos.size() - 1; i >= 0; i--) {
            IEstadoAlterado estado = estadosActivos.get(i);
            estado.aplicarEfecto(this);
            
            if (!estado.puedeAtacar()) {
                puedeAtacar = false;
            }
            
            estado.reducirTurno();
            
            if (!estado.estaActivo()) {
                System.out.println("  [System] El efecto " + estado.getNombre() + " ha terminado para " + nombre);
                if (estado instanceof AumentarFuerza) {
                    ((AumentarFuerza) estado).limpiarEfecto(this);
                }
                estadosActivos.remove(i);
            }
        }
        return puedeAtacar && vida > 0;
    }

    public void agregarEstado(IEstadoAlterado estado) {
        this.estadosActivos.add(estado);
        System.out.println("⚡ " + nombre + " ha sido afectado por: " + estado.getNombre());
    }

    public void defender(int danio) {
        int danioFinal = danio - defensa;
        if (danioFinal < 0){
            danioFinal = 0;
        }
        vida -= danioFinal;
    }

    public void subirNivel() {
        nivel++;
        vida += 10;
        ataque += 2;
        defensa += 2;
    }

    public String getNombre() { return nombre; }
    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }
    public int getAtaque() { return ataque; }
    public void setAtaque(int ataque) { this.ataque = ataque; }
    public int getNivel() { return nivel; }
    public String getTipo() { return tipo; }

    @Override
    public String toString() {
        return nombre + " [" + tipo + "]" +
               " | Vida: " + vida +
               " | Nivel: " + nivel +
               " | Ataque: " + ataque +
               " | Defensa: " + defensa;
    }
}