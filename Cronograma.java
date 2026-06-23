public class Cronograma {

    // Matriz que almacena los duelos.
    // Las filas representan los días y las columnas los horarios.
    private Duelo[][] cronograma;

    // Cantidad fija de días y horarios disponibles.
    private static final int cantDias = 7;
    private static final int cantHorarios = 15;

    // ==========================
    // CONSTRUCTOR
    // ==========================

    /**
     * Crea un cronograma vacío de 7 días y 15 horarios por día.
     */
    public Cronograma() {
        this.cronograma = new Duelo[cantDias][cantHorarios];
    }

    // ==========================
    // OBSERVADORES
    // ==========================

    /**
     * Devuelve el duelo almacenado en un día y horario determinados.
     *
     * @param dia Día a consultar.
     * @param hora Hora real (8 a 22).
     * @return Duelo almacenado o null si no hay ninguno.
     */
    public Duelo getDuelo(int dia, int hora) {
        return cronograma[dia][horaIndice(hora)];
    }

    // ==========================
    // MÉTODOS PROPIOS DEL TDA
    // ==========================

    /**
     * Convierte una hora real a un índice de matriz.
     *
     * Ejemplo:
     * Hora 8  -> índice 0
     * Hora 9  -> índice 1
     * Hora 22 -> índice 14
     *
     * @param hora Hora real.
     * @return Índice correspondiente en la matriz.
     */
    public static int horaIndice(int hora) {
        return hora - 8;
    }

    /**
     * Verifica si existe un duelo con el número indicado.
     *
     * Utiliza el método buscarDuelo().
     *
     * @param numero Número de duelo.
     * @return true si existe, false en caso contrario.
     */
    public boolean existeDuelo(int numero) {
        boolean existe = false;

        if (buscarDuelo(numero) != null) {
            existe = true;
        }

        return existe;
    }

    /**
     * Verifica si un horario de un determinado día está libre.
     *
     * @param dia Día a consultar.
     * @param hora Hora a consultar.
     * @return true si está libre, false si ya hay un duelo.
     */
    public boolean horarioDisponible(int dia, int hora) {
        boolean disponible = false;
        int indice = horaIndice(hora);

        if (cronograma[dia][indice] == null) {
            disponible = true;
        }

        return disponible;
    }

    /**
     * Busca un duelo por su número.
     *
     * Recorre toda la matriz hasta encontrarlo.
     *
     * @param numero Número del duelo.
     * @return El duelo encontrado o null si no existe.
     */
    public Duelo buscarDuelo(int numero) {

        Duelo encontrado = null;
        int dia = 0;

        while (dia < cantDias && encontrado == null) {

            int hora = 0;

            while (hora < cantHorarios && encontrado == null) {

                if (cronograma[dia][hora] != null) {

                    if (cronograma[dia][hora].getNumDuelo() == numero) {
                        encontrado = cronograma[dia][hora];
                    }
                }

                hora++;
            }

            dia++;
        }

        return encontrado;
    }

    /**
     * Verifica si un personaje participa en algún duelo de un día específico.
     *
     * @param Cadena Nombre del personaje.
     * @param dia Día a revisar.
     * @return true si participa en algún duelo ese día.
     */
    public boolean personajeOcupadoEseDia(String Cadena, int dia) {

        boolean encontrado = false;
        int hora = 0;

        while (hora < cantHorarios && !encontrado) {

            if (cronograma[dia][hora] != null) {

                if (cronograma[dia][hora].involucraPersonaje(Cadena)) {
                    encontrado = true;
                }
            }

            hora++;
        }

        return encontrado;
    }

    /**
     * Agrega un duelo al cronograma.
     *
     * Solo se agrega si la posición correspondiente está vacía.
     *
     * @param d Duelo a agregar.
     * @return true si pudo agregarse.
     */
    public boolean agregarDuelo(Duelo d) {

        boolean agregado = false;

        int indice = horaIndice(d.getHora());

        if (cronograma[d.getDia()][indice] == null) {

            cronograma[d.getDia()][indice] = d;
            agregado = true;
        }

        return agregado;
    }

    /**
     * Obtiene todos los duelos de un día determinado.
     *
     * Primero calcula cuántos hay para crear el arreglo
     * con el tamaño exacto.
     *
     * @param dia Día consultado.
     * @return Arreglo con todos los duelos del día.
     */
    public Duelo[] obtenerDuelosDelDia(int dia) {

        Duelo[] duelos = new Duelo[cantidadDuelosPorDia(dia)];

        int indiceDuelos = 0;

        for (int hora = 0; hora < cantHorarios; hora++) {

            if (cronograma[dia][hora] != null) {

                duelos[indiceDuelos] = cronograma[dia][hora];
                indiceDuelos++;
            }
        }

        return duelos;
    }

    /**
     * Cuenta cuántos duelos existen en un día.
     *
     * @param dia Día consultado.
     * @return Cantidad de duelos.
     */
    public int cantidadDuelosPorDia(int dia) {

        int cantidadDuelos = 0;

        for (int hora = 0; hora < cantHorarios; hora++) {

            if (cronograma[dia][hora] != null) {
                cantidadDuelos++;
            }
        }

        return cantidadDuelos;
    }

    /**
     * Método recursivo incompleto.
     * Parece estar pensado para recorrer la matriz.
     */
    public void recorrerMatriz(int indiceFila, int indiceCol) {

        if (indiceFila <= cronograma.length) {

        }
    }

    /**
     * Cuenta recursivamente los duelos realizados.
     *
     * Los parámetros deben comenzar en:
     * duelosRealizados(0,0,0)
     *
     * Recorre toda la matriz fila por fila.
     *
     * @param indiceFila Fila actual.
     * @param indiceCol Columna actual.
     * @param cantDuelos Acumulador.
     * @return Cantidad de duelos realizados.
     */
    public int duelosRealizados(int indiceFila, int indiceCol, int cantDuelos) {

        // Caso base: se recorrió toda la matriz.
        if (indiceFila > cronograma.length - 1) {

        }

        // Fin de una fila: pasar a la siguiente.
        else if (indiceCol > cronograma[0].length - 1) {

            cantDuelos = duelosRealizados(indiceFila + 1, 0, cantDuelos);
        }

        else {

            // Si existe un duelo y está realizado, contarlo.
            if (cronograma[indiceFila][indiceCol] != null &&
                    cronograma[indiceFila][indiceCol]
                            .getEstado()
                            .equalsIgnoreCase("realizado")) {

                cantDuelos++;
            }

            // Continuar con la siguiente columna.
            cantDuelos = duelosRealizados(indiceFila,
                    indiceCol + 1,
                    cantDuelos);
        }

        return cantDuelos;
    }

    /**
     * Cuenta recursivamente todos los horarios vacíos.
     *
     * Debe iniciarse con:
     * cantidadHorariosLibres(0,0,0)
     *
     * @param indiceFila Fila actual.
     * @param indiceCol Columna actual.
     * @param cantHorarios Acumulador.
     * @return Cantidad de horarios libres.
     */
    public int cantidadHorariosLibres(int indiceFila,
            int indiceCol,
            int cantHorarios) {

        // Caso base: se recorrió toda la matriz.
        if (indiceFila > cronograma.length - 1) {

        }

        // Fin de fila.
        else if (indiceCol > cronograma[0].length - 1) {

            cantHorarios = cantidadHorariosLibres(
                    indiceFila + 1,
                    0,
                    cantHorarios);
        }

        else {

            // Si la posición está vacía, contarla.
            if (cronograma[indiceFila][indiceCol] == null) {
                cantHorarios++;
            }

            // Continuar recorriendo.
            cantHorarios = cantidadHorariosLibres(
                    indiceFila,
                    indiceCol + 1,
                    cantHorarios);
        }

        return cantHorarios;
    }

    /**
     * Busca el primer duelo que usa arma mágica en cada día.
     *
     * Devuelve un arreglo de 7 posiciones:
     *
     * - La hora del primer duelo con arma mágica de ese día.
     * - -1 si ese día no existe ninguno.
     *
     * Ejemplo:
     * [10, -1, 15, 8, -1, -1, 12]
     *
     * @return Arreglo con los horarios encontrados.
     */
    public int[] primerDueloConArmaMagica() {

        int j = 0;

        boolean armaEncontrada = false;

        int[] horarios = new int[7];

        for (int i = 0; i < cronograma.length; i++) {

            while (j < cronograma[0].length && !armaEncontrada) {

                if (cronograma[i][j] != null &&
                        cronograma[i][j].usaArmaMagica()) {

                    armaEncontrada = true;

                    horarios[i] = cronograma[i][j].getHora();
                }

                j++;
            }

            // Si no encontró ningún duelo con arma mágica.
            if (!armaEncontrada) {
                horarios[i] = -1;
            }

            // Reiniciar búsqueda para el siguiente día.
            j = 0;
            armaEncontrada = false;
        }

        return horarios;
    }

    // ==========================
    // FIN DEL TDA
    // ==========================
}
