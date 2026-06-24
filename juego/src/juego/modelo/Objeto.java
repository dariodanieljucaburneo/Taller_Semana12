
package juego.modelo;

public abstract class Objeto {
    protected String nombre;
    protected int atq, def;

    public Objeto(String nombre, int atq, int def) {
        this.nombre = nombre;
        this.atq = atq;
        this.def = def;
    }

    public int getAtq() {
        return atq;
    }

    public int getDef() {
        return def;
    }

    public String getNombre() {
        return nombre;
    }
}
