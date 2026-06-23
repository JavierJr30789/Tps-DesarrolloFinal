public class Personaje {
 // ==========================
    // ATRIBUTOS
    // ==========================

    // Código único que identifica al personaje.
    private String codigo;

    // Nombre del personaje.
    private String nombre;

    // Tipo o categoría del personaje.
    // Ejemplo: Guerrero, Mago, Arquero, etc.
    private String tipo;

    // Nivel de energía o poder base del personaje.
    private int nivelDeEnergia;

    // Cantidad de duelos ganados.
    private int cantDuelosGanados;

    // Cantidad de duelos perdidos.
    private int cantDuelosPerdidos;

       // ==========================
    // CONSTRUCTOR
    // ==========================

    /**
     * Crea un personaje con todos sus datos.
     *
     * @param cod Código identificador.
     * @param nn Nombre del personaje.
     * @param tipo Tipo de personaje.
     * @param nivEner Nivel de energía.
     * @param dueGa Cantidad de duelos ganados.
     * @param duePer Cantidad de duelos perdidos.
     */
    public Personaje (String cod, String nn, String tipo, int nivEner, int dueGa, int duePer){
        this.codigo = cod;
        this.nombre = nn;
        this.tipo = tipo;
        this.nivelDeEnergia = nivEner;
        this.cantDuelosGanados = dueGa;
        this.cantDuelosPerdidos = duePer; 
    }

    
    // ==========================
    // OBSERVADORES (GETTERS)
    // ==========================

    /**
     * Devuelve el código del personaje.
     */
    public String getCodigo() {
        return this.codigo;
    }

    /**
     * Devuelve el nombre del personaje.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve el tipo del personaje.
     */
    public String getTipo() {
        return this.tipo;
    }

    /**
     * Devuelve el nivel de energía.
     */
    public int getNivelDeEnergia() {
        return this.nivelDeEnergia;
    }

    /**
     * Devuelve la cantidad de duelos ganados.
     */
    public int getCantDuelosGanados() {
        return this.cantDuelosGanados;
    }

    /**
     * Devuelve la cantidad de duelos perdidos.
     */
    public int getCantDuelosPerdidos() {
        return this.cantDuelosPerdidos;
    }
  // ==========================
    // REPRESENTACIÓN EN TEXTO
    // ==========================

    /**
     * Devuelve una representación textual completa del personaje.
     *
     * Ejemplo:
     *
     * PERSONAJE
     * Nombre: Goku
     * Tipo: Guerrero
     * Nivel de energia: 9000
     * Duelos ganados: 15
     * Duelos perdidos: 3
     * Porcentaje de victorias: 83.33
     */
@Override
    public String toString(){
        return "PERSONAJE\nNombre: "+this.nombre+"\nTipo: "+this.tipo+"\nNivel de energia: "+this.nivelDeEnergia+
        "\nDuelos ganados: "+this.cantDuelosGanados+"\nDuelos perdidos: "+this.cantDuelosPerdidos+"\nPorcentaje de victorias: "+porcentajeVictoria();
    }

    //modificadores

    
    // ==========================
    // MÉTODOS PROPIOS DEL TDA
    // ==========================

    /**
     * Compara dos personajes mediante su código.
     *
     * Dos personajes son considerados iguales
     * si poseen el mismo código.
     *
     * @param otro Personaje a comparar.
     * @return true si tienen el mismo código.
     */
    @Override
public boolean equals(Object obj) {
    if (obj instanceof Personaje otro) {
        return this.codigo.equals(otro.codigo);
    }
    return false;
}
  /**
     * Calcula la cantidad total de duelos disputados.
     *
     * Fórmula:
     * ganados + perdidos
     *
     * @return Total de duelos.
     */
    public int totalDuelos(){
        return cantDuelosGanados+cantDuelosPerdidos;
    }
  /**
     * Calcula el porcentaje de victorias.
     *
     * Fórmula:
     * (duelosGanados / totalDuelos) * 100
     *
     * Si no disputó ningún duelo devuelve 0.
     *
     * @return Porcentaje de victorias.
     */
    public double porcentajeVictoria(){
        double porcentaje = 0;
        if(totalDuelos()!=0){
            porcentaje = ((double)cantDuelosGanados/totalDuelos())*100;
        }
        return porcentaje;
    }
  /**
     * Incrementa en uno la cantidad de duelos ganados.
     *
     * Se utiliza cuando el personaje gana un duelo.
     */
    public void incrementarDuelosGanados(){
        this.cantDuelosGanados++;
    }
   /**
     * Incrementa en uno la cantidad de duelos perdidos.
     *
     * Se utiliza cuando el personaje pierde un duelo.
     */
    public void incrementarDuelosPerdidos(){
        this.cantDuelosPerdidos++;
    }


}
