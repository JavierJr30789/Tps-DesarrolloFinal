public class Personaje {
    private String codigo;
    private String nombre;
    private String tipo;
    private int nivelDeEnergia;
    private int cantDuelosGanados;
    private int cantDuelosPerdidos;

    //constructor
    public Personaje (String cod, String nn, String tipo, int nivEner, int dueGa, int duePer){
        this.codigo = cod;
        this.nombre = nn;
        this.tipo = tipo;
        this.nivelDeEnergia = nivEner;
        this.cantDuelosGanados = dueGa;
        this.cantDuelosPerdidos = duePer; 
    }

    //observadores
    public String getCodigo(){
        return this.codigo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getTipo(){
        return this.tipo;
    }

    public int getNivelDeEnergia(){
        return this.nivelDeEnergia;
    }

    public int getCantDuelosGanados(){
        return this.cantDuelosGanados;
    }

    public int getCantDuelosPerdidos(){
        return this.cantDuelosPerdidos;
    }

@Override
    public String toString(){
        return "PERSONAJE\nNombre: "+this.nombre+"\nTipo: "+this.tipo+"\nNivel de energia: "+this.nivelDeEnergia+
        "\nDuelos ganados: "+this.cantDuelosGanados+"\nDuelos perdidos: "+this.cantDuelosPerdidos+"\nPorcentaje de victorias: "+porcentajeVictoria();
    }

    //modificadores

    //propios del tipo
    public boolean equals(Personaje otro){
        return this.codigo.equals(otro.getCodigo());
    }

    public int totalDuelos(){
        return cantDuelosGanados+cantDuelosPerdidos;
    }

    public double porcentajeVictoria(){
        double porcentaje = 0;
        if(totalDuelos()!=0){
            porcentaje = ((double)cantDuelosGanados/totalDuelos())*100;
        }
        return porcentaje;
    }

    public void incrementarDuelosGanados(){
        this.cantDuelosGanados++;
    }

    public void incrementarDuelosPerdidos(){
        this.cantDuelosPerdidos++;
    }


}
