package juego.modelo;

public abstract class Personaje {

    protected String nombre;
    protected int vida;
    protected int ataque;
    protected int defensa;
    protected int nivel;
    protected String tipo;
<<<<<<< HEAD:juego/juego/src/juego/modelo/Personaje.java
    protected int energia;
    protected int maxEnergia = 100;
    protected int cooldown = 0;
=======
    protected Objeto obj;
>>>>>>> origin/main:juego/src/juego/modelo/Personaje.java

    public Personaje(String nombre, int vida, int ataque, int defensa, int nivel, String tipo, Objeto obj) {
        this.nombre = nombre;
        this.vida = vida;
<<<<<<< HEAD:juego/juego/src/juego/modelo/Personaje.java
        this.ataque = ataque;
        this.defensa = defensa;
        this.nivel = (int) (Math.random() * 100) + 1;
        this.tipo = tipo;
        this.energia = maxEnergia;
=======
        this.ataque = (ataque + obj.getAtq());
        this.defensa = (defensa + obj.getDef());
        this.nivel = nivel;
        this.tipo = tipo;
        this.obj = obj;
>>>>>>> origin/main:juego/src/juego/modelo/Personaje.java
    }

    public abstract int atacar();

    public void defender(int danio) {
<<<<<<< HEAD:juego/juego/src/juego/modelo/Personaje.java
        int danioFinal = danio - defensa;
        if (danioFinal < 0) {
=======
        int danioFinal = danio - defensa - obj.getDef();
        if (danioFinal < 0){
>>>>>>> origin/main:juego/src/juego/modelo/Personaje.java
            danioFinal = 0;
        }
        vida -= danioFinal;
        if (vida < 0) {
            vida = 0;
        }
    }

    public void subirNivel() {
        nivel++;
        vida += 10;
        ataque += 2;
        defensa += 2;
    }

    public int usarHabilidadEspecial() throws Exception {
        if (energia < 20) {
            throw new Exception(nombre + " no tiene suficiente energia");
        }
        if (cooldown > 0) {
            throw new Exception(nombre + " habilidad en cooldown");
        }

        energia -= 20;
        cooldown = 2;

        return habilidadEspecial();
    }

    protected abstract int habilidadEspecial();

    public void reducirCooldown() {
        if (cooldown > 0) {
            cooldown--;
        }
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

    public int getCooldown() {
        return cooldown;
    }

    public int getEnergia() {
        return energia;
    }

    @Override
    public String toString() {
<<<<<<< HEAD:juego/juego/src/juego/modelo/Personaje.java
        return nombre + " [" + tipo + "]"
                + " | Vida: " + vida
                + " | Nivel: " + nivel
                + " | Ataque: " + ataque
                + " | Defensa: " + defensa
                + " | Energia: " + energia
                + " | Cooldown: " + cooldown;
=======
        return nombre + " [" + tipo + "]" +
               " | Vida: " + vida +
               " | Nivel: " + nivel +
               " | Ataque: " + ataque +
               " | Defensa: " + defensa + 
               " | Objeto: " + obj.getNombre();
>>>>>>> origin/main:juego/src/juego/modelo/Personaje.java
    }

    public void resetearEstado() {

        // Restaurar vida según tipo
        if (tipo.equals("Guerrero")) {
            vida = 100;
        } else if (tipo.equals("Mago")) {
            vida = 80;
        } else if (tipo.equals("Arquero")) {
            vida = 90;
        }
        energia = maxEnergia;
        cooldown = 0;
    }

}
