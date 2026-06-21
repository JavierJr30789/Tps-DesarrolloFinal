public class Duelo {

    private int numeroDuelo;
    private Personaje personaje1;
    private Personaje personaje2;
    private Arma arma1;
    private Arma arma2;
    private Arena arena;
    private int dia;
    private int hora;
    private String estado;
    private Personaje ganador;

    public Duelo(int numero, Personaje p1, Personaje p2, Arma a1, Arma a2, Arena arena, int dia, int hora) {

        this.numeroDuelo = numero;
        this.personaje1 = p1;
        this.personaje2 = p2;
        this.arma1 = a1;
        this.arma2 = a2;
        this.arena = arena;
        this.dia = dia;
        this.hora = hora;

    }

    public int getNumDuelo() {
        return this.numeroDuelo;
    }

    public Personaje getPersonaje1() {
        return this.personaje1;
    }

    public Personaje getPersonaje2() {
        return this.personaje2;
    }

    public Arma getArma1() {
        return this.arma1;
    }

    public Arma getArma2() {
        return this.arma2;
    }

    public String getEstado() {
        return estado;
    }

    public boolean marcarRealizado(Personaje personajeGanador) {

        boolean resultado = false;

        if (estado.equalsIgnoreCase("programado")) {
            if (personajeGanador == personaje1 || personajeGanador == personaje2) {
                ganador = personajeGanador;
                estado = "realizado";

            }
            if (personajeGanador == personaje1) {
                personaje1.incrementarDuelosGanados();
                personaje2.incrementarDuelosPerdidos();
            } else {
                personaje2.incrementarDuelosGanados();
                personaje1.incrementarDuelosPerdidos();
            }

            resultado = true;
        }

        return resultado;
    }

    public int calcularPoderTotal() {
        int total = personaje1.getEnergia() + arma1.getPoderAtaque() + personaje2.getEnergia() + arma2.getPoderAtaque();
        return total;
    }

    public boolean involucraPersonaje(String codigo) {
        boolean resultado = false;
        if (personaje1.getCodigo().equalsIgnoreCase(codigo) || personaje2.getCodigo().equalsIgnoreCase(codigo)) {
            resultado = true;
        }
        return resultado;
    }

    public boolean usaArmaMagica(){
    boolean resultado = false;

    if(arma1.esMagica() || arma2.esMagica()){
    resultado = true;
    }

    return resultado;
    }

    @Override
    public String toString(){
    return "Duelo #"+numeroDuelo+" - "+personaje1.getNombre()+" vs "+personaje2.getNombre()+" - Dia:"+dia+" Hora:"+hora+" - Estado:"+estado;
    }
}
