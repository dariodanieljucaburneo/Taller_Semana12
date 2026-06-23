package juego.modelo;

public abstract class Personaje {

    protected String nombre;
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected int nivel;
    protected String tipo; 

    public Personaje(String nombre, int vida, int ataque, int defensa, int nivel, String tipo) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.defensa = defensa;
        this.nivel = nivel;
        this.tipo = tipo;
    }

    public abstract int atacar();

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

    public String getNombre() { 
        return nombre; 
    }
    public int getVida() { 
        return vida; 
    }
    public int getNivel() { 
        return nivel; 
    }
    public String getTipo() { 
        return tipo; 
    }

    @Override
    public String toString() {
        return nombre + " [" + tipo + "]" +
               " | Vida: " + vida +
               " | Nivel: " + nivel +
               " | Ataque: " + ataque +
               " | Defensa: " + defensa;
    }
}