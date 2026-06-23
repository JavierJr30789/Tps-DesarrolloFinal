public class Arena {

    // ==========================
    // ATRIBUTOS
    // ==========================

    // Código único que identifica la arena.
    private String Codigo;

    // Nombre de la arena.
    private String Nombre;

    // Ubicación donde se encuentra la arena.
    private String Ubicacion;

    // Cantidad máxima de espectadores.
    private int CantidadEspec;

    // Nivel de dificultad de la arena.
    // Puede representar peligrosidad, complejidad del terreno, etc.
    private int Dificultad;

    // ==========================
    // CONSTRUCTOR
    // ==========================

    /**
     * Crea una arena con todos sus datos.
     *
     * @param Cod Código identificador.
     * @param Nom Nombre de la arena.
     * @param Ubi Ubicación.
     * @param CantEspec Cantidad de espectadores.
     * @param Dif Nivel de dificultad.
     */
    public Arena(String Cod, String Nom, String Ubi, int CantEspec, int Dif) {
        this.Codigo = Cod;
        this.Nombre = Nom;
        this.Ubicacion = Ubi;
        this.CantidadEspec = CantEspec;
        this.Dificultad = Dif;
    }
 // ==========================
    // OBSERVADORES (GETTERS)
    // ==========================

    /**
     * Devuelve el código de la arena.
     */
    public String getCodigo() {
        return this.Codigo;
    }

    /**
     * Devuelve el nombre de la arena.
     */
    public String getNombre() {
        return this.Nombre;
    }

    /**
     * Devuelve la ubicación de la arena.
     */
    public String getUbicacion() {
        return this.Ubicacion;
    }

    /**
     * Devuelve la cantidad de espectadores.
     */
    public int getCantidadEspec() {
        return this.CantidadEspec;
    }

    /**
     * Devuelve el nivel de dificultad.
     */
    public int getDificultad() {
        return this.Dificultad;
    }

    // ==========================
    // MODIFICADORES (SETTERS)
    // ==========================

    /**
     * Modifica el código de la arena.
     */
    public void setCódigo(String Cod) {
        this.Codigo = Cod;
    }

    /**
     * Modifica el nombre de la arena.
     */
    public void setNombre(String Nom) {
        this.Nombre = Nom;
    }

    /**
     * Modifica la ubicación de la arena.
     */
    public void setUbicacion(String Ubi) {
        this.Ubicacion = Ubi;
    }

    /**
     * Modifica la cantidad de espectadores.
     */
    public void setCantidadEspec(int CantEspec) {
        this.CantidadEspec = CantEspec;
    }

    /**
     * Modifica el nivel de dificultad.
     */
    public void setDificultad(int Dif) {
        this.Dificultad = Dif;
    }

    // ==========================
    // MÉTODOS PROPIOS DEL TDA
    // ==========================

    /**
     * Devuelve una representación textual de la arena.
     *
     * Ejemplo:
     * Arena{
     * Código='A01',
     * Nombre='Coliseo',
     * Ubicacion='Roma',
     * CantidadEspec=50000,
     * Dificultad='8'
     * }
     */    
    @Override
    public String toString() {
        return "Arena{" +
                "Código='" + Codigo + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Ubicacion='" + Ubicacion + '\'' +
                ", CantidadEspec=" + CantidadEspec +
                ", Dificultad='" + Dificultad + '\'' +
                '}';
    }
 /**
     * Compara dos arenas utilizando su código.
     *
     * Dos arenas se consideran iguales
     * si poseen el mismo código.
     *
     * @param otro Arena a comparar.
     * @return true si tienen el mismo código.
     */

@Override
public boolean equals(Object obj) {
    if (obj instanceof Arena otra) {
        return this.Codigo.equals(otra.Codigo);
    }
    return false;
}
}

    
