public class Duelo {

    // ==========================
    // ATRIBUTOS
    // ==========================

    // Número identificador único del duelo.
    private String numeroDuelo;

    // Participantes del duelo.
    private Personaje personaje1;
    private Personaje personaje2;

    // Armas utilizadas por cada participante.
    private Arma arma1;
    private Arma arma2;

    // Arena donde se llevará a cabo el duelo.
    private Arena arena;

    // Día y hora programados para el duelo.
    private int dia;
    private int hora;

    // Estado actual del duelo.
    // Ejemplos: "programado", "realizado".
    private String estado;

    // Personaje que resultó ganador del duelo.
    private Personaje ganador;

    // ==========================
    // CONSTRUCTOR
    // ==========================
    /**
     * Crea un nuevo duelo con toda la información necesaria.
     *
     * @param numero Número identificador del duelo.
     * @param p1 Primer participante.
     * @param p2 Segundo participante.
     * @param a1 Arma del primer participante.
     * @param a2 Arma del segundo participante.
     * @param arena Arena donde se realizará.
     * @param dia Día programado.
     * @param hora Hora programada.
     */
    public Duelo(String numero, Personaje p1, Personaje p2,Arma a1, Arma a2, Arena arena, int dia, int hora, String programado) {

        this.numeroDuelo = numero;
        this.personaje1 = p1;
        this.personaje2 = p2;
        this.arma1 = a1;
        this.arma2 = a2;
        this.arena = arena;
        this.dia = dia;
        this.hora = hora;
        this.estado = "programado";
    }

    // ==========================
    // OBSERVADORES (GETTERS)
    // ==========================
    /**
     * Devuelve el número identificador del duelo.
     */
    public String getNumDuelo() {
        return this.numeroDuelo;
    }
    /**
     * Devuelve el primer personaje participante.
     */
    public Personaje getPersonaje1() {
        return this.personaje1;
    }
    /**
     * Devuelve el segundo personaje participante.
     */
    public Personaje getPersonaje2() {
        return this.personaje2;
    }
    /**
     * Devuelve el arma del primer personaje.
     */
    public Arma getArma1() {
        return this.arma1;
    }
    /**
     * Devuelve el arma del segundo personaje.
     */
    public Arma getArma2() {
        return this.arma2;
    }
    /**
     * Devuelve el estado actual del duelo.
     */
    public String getEstado() {
        return estado;
    }
    /**
     * Devuelve la hora programada.
     */
    public int getHora() {
        return this.hora;
    }
    /**
     * Devuelve el día programado.
     */
    public int getDia() {
        return this.dia;
    }
    // ==========================
    // MÉTODOS PROPIOS DEL TDA
    // ==========================
    /**
     * Marca el duelo como realizado.
     *
     * Verifica que:
     * 1) El duelo esté programado.
     * 2) El ganador indicado sea uno de los participantes.
     *
     * Luego:
     * - Guarda el ganador.
     * - Cambia el estado a "realizado".
     * - Actualiza estadísticas de ganados y perdidos.
     *
     * @param personajeGanador Personaje ganador.
     * @return true si pudo registrarse correctamente.
     */
    public boolean marcarRealizado(Personaje personajeGanador) {

    boolean resultado = false;

    // Solo puede realizarse si estaba programado.
    if (estado.equalsIgnoreCase("programado")) {

        // Verifica que el ganador sea uno de los participantes.
        if (personajeGanador == personaje1 || personajeGanador == personaje2) {

            ganador = personajeGanador;
            estado = "realizado";

            // Actualiza estadisticas.
            if (personajeGanador == personaje1) {
                personaje1.incrementarDuelosGanados();
                personaje2.incrementarDuelosPerdidos();
            } else {
                personaje2.incrementarDuelosGanados();
                personaje1.incrementarDuelosPerdidos();
            }

            resultado = true;
        }
    }

    return resultado;
}
    
    /**
     * Calcula el poder total del duelo.
     *
     * Se suma:
     * - Energía del personaje 1.
     * - Poder de su arma.
     * - Energía del personaje 2.
     * - Poder de su arma.
     *
     * @return Poder total combinado.
     */
    public int calcularPoderTotal() {

        int total =
                personaje1.getNivelDeEnergia() + arma1.getPoder()+ personaje2.getNivelDeEnergia()+ arma2.getPoder();

        return total;
    }
    /**
     * Verifica si un personaje participa en el duelo.
     *
     * Compara el código recibido con el código
     * de ambos participantes.
     *
     * @param codigo Código del personaje.
     * @return true si participa.
     */
    public boolean involucraPersonaje(String codigo) {

        boolean resultado = false;

        if (personaje1.getCodigo().equalsIgnoreCase(codigo)
                || personaje2.getCodigo().equalsIgnoreCase(codigo)) {

            resultado = true;
        }
        return resultado;
    }
    /**
     * Verifica si alguna de las armas utilizadas
     * en el duelo es mágica.
     *
     * @return true si al menos una es mágica.
     */
    public boolean usaArmaMagica() {

        boolean resultado = false;

        if (arma1.esMagica() || arma2.esMagica()) {
            resultado = true;
        }

        return resultado;
    }
    // ==========================
    // REPRESENTACIÓN EN TEXTO
    // ==========================
    /**
     * Devuelve una representación textual del duelo.
     *
     * Ejemplo:
     * Duelo #5 - Goku vs Vegeta - Dia:2 Hora:10 - Estado:realizado
     */
    @Override
    public String toString() {
        return "Duelo #"+ numeroDuelo+ " - "+ personaje1.getNombre()+ " vs "+ personaje2.getNombre()+ " - Dia:"+ dia+ " Hora:"+ hora+ " - Estado:"+ estado;
    }
}