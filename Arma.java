 public class Arma {
 // ==========================
    // ATRIBUTOS
    // ==========================

    // Código único que identifica el arma.
    private String Codigo;

    // Nombre del arma.
    private String Nombre;

    // Tipo de arma.
    // Ejemplos: Espada, Arco, Hacha, Bastón, etc.
    private String Tipo;

    // Nivel de poder que aporta el arma.
    private int Poder;

    // Indica si el arma posee propiedades mágicas.
    private boolean magica;

    // ==========================
    // CONSTRUCTOR
    // ==========================

    /**
     * Crea un arma con todos sus datos.
     *
     * @param Cod Código identificador.
     * @param Nom Nombre del arma.
     * @param Tip Tipo de arma.
     * @param Pod Poder del arma.
     * @param esmag Indica si es mágica.
     */
public Arma(String Cod, String Nom, String Tip, int Pod, boolean esmag){
    this.Codigo = Cod;
        this.Nombre = Nom;
        this.Tipo = Tip;
        this.Poder = Pod;
this.magica = esmag;
}
 // ==========================
    // OBSERVADORES (GETTERS)
    // ==========================

    /**
     * Devuelve el código del arma.
     */
    public String getCodigo() {
        return Codigo;
    }

    /**
     * Devuelve el nombre del arma.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Devuelve el tipo del arma.
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * Devuelve el poder del arma.
     */
    public int getPoder() {
        return Poder;
    }

    // ==========================
    // MODIFICADORES (SETTERS)
    // ==========================

    /**
     * Modifica el código del arma.
     */
    public void setCodigo(String Cod) {
        this.Codigo = Cod;
    }

    /**
     * Modifica el nombre del arma.
     */
    public void setNombre(String Nom) {
        this.Nombre = Nom;
    }
    /**
     * Modifica el tipo del arma.
     */
    public void setTipo(String Tip) {
        this.Tipo = Tip;
    }
    /**
     * Modifica el poder del arma.
     */
    public void setPoder(int Pod) {
        this.Poder = Pod;
    }

    public boolean getMagica() {
    return magica;
}

public void setMagica(boolean magica) {
    this.magica = magica;
}
    // ==========================
    // REPRESENTACIÓN EN TEXTO
    // ==========================
    /**
     * Devuelve una representación textual del arma.
     *
     * Ejemplo:
     * Arma{
     * Codigo=A01,
     * Nombre='Excalibur',
     * Tipo='Espada',
     * Poder='100'
     * }
     */
@Override
    //Propias del tipo
    public String toString() {
        return "Arma{" +
                "Codigo=" + Codigo +
                ", Nombre='" + Nombre + '\'' +
                ", Tipo='" + Tipo + '\'' +
                ", Poder='" + Poder + '\'' +
                '}';
    }
  // ==========================
    // MÉTODOS PROPIOS DEL TDA
    // ==========================

    /**
     * Indica si el arma es mágica.
     *
     * @return true si es mágica.
     */
    public boolean esMagica() {

        return this.magica;
    }

    /**
     * Compara dos armas utilizando su código.
     *
     * Dos armas son consideradas iguales
     * si tienen el mismo código.
     *
     * @param otro Arma a comparar.
     * @return true si poseen el mismo código.
     */
@Override
public boolean equals(Object obj) {
    if (obj instanceof Arma otra) {
        return this.Codigo.equals(otra.Codigo);
    }
    return false;
}

}