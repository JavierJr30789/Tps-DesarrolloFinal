
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;// captura cualquier error que ocurra durante la lectura.

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
            cantDuelos = duelosRealizados(indiceFila,indiceCol + 1,cantDuelos);
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

/**
 * Ordena los duelos de un dia determinado segun su poder total
 * de combate, de menor a mayor, utilizando el metodo de Insercion.
 *
 * Reutiliza obtenerDuelosDelDia(dia) para conseguir el arreglo
 * de duelos de ese dia antes de ordenarlo.
 *
 * @param dia Dia a ordenar.
 * @return Arreglo de duelos del dia, ordenado por poder total.
 * 
 * metodo de insersion en resumen lo que hace en el for recorre el arreglo desde el segundo elemento
 * luego le asigna al elemento de indice i a una variable auxiliar
 * posterior a eso inicializa j que va a ser igual al indice anterior a i en cada vuelta
 * dentro de otro ciclo, compara el elemento de inidice j con el elemento actual del arreglo,
 * si es mayor le asigna el valor del elemento de indice j al siguiente que seria j+1
 * y le resta 1 al indice j
 * sale del while si el elemento anterior al elemento de inidce i es menor de la variable actual, o si en el primer caso cuando j = -1
 * fuera del while, al elemento del indice (j-1)+1 = j le asigna el valor guardado en la variable actual en el cual dentro de la repetitiva
 * while fue considerado como el menor es decir a la mueve el valor menor a la izquierda
 */
public Duelo[] ordenarDuelosPorDia(int dia){
 Duelo[] duelosOrdenados = obtenerDuelosDelDia(dia); //guardo en el arreglo la fila que que representa el indice de dia
 // Insercion: recorre desde el segundo elemento
    for(int i = 1; i < duelosOrdenados.length; i++){
    //en la primera vuelta i vale 1 asi que actual es igual al 2do elemento del arreglo
    Duelo actual = duelosOrdenados[i]; 
    //j valdria 0 en la primera vuelta
    int j = i-1; 
     // Desplaza los elementos mayores una posicion a la derecha
    while (j >= 0 && duelosOrdenados[j].calcularPoderTotal() > actual.calcularPoderTotal()){
    
    duelosOrdenados[j+1] = duelosOrdenados[j];
    j = j-1;
    }
       // Inserta el elemento actual en su posicion correcta    
    duelosOrdenados[j+1] = actual;
    }

 return duelosOrdenados;
}

// ==========================
// duelosEnRangoDePoder
// ==========================

/**
 * Obtiene todos los duelos cuyo poder total de combate esta
 * comprendido entre un valor minimo y un valor maximo (inclusive).
 *
 * Recorre toda la matriz dos veces: primero para contar cuantos
 * duelos cumplen la condicion (y asi crear el arreglo del tamaño
 * exacto), y luego para llenarlo.
 *
 * @param poderMin Poder minimo del rango.
 * @param poderMax Poder maximo del rango.
 * @return Arreglo con los duelos cuyo poder esta dentro del rango.
 */

public Duelo[] duelosEnRangoDePoder(int poderMin, int poderMax){
//aca guardamos la cantidad de duelos encontrados en el otro metodo para usarlos en la longitud del arreglo
 int cantidad = cantDuelosEnRangoDePoder(poderMin, poderMax); 
 //declaramos el arreglo donde guardaremos los duelos en el rango de poder
 Duelo[] duelosEnRango = new Duelo[cantidad];
 //usaremos la variable indice para avanzar en posiciones del arreglo cada que contremos un duelo valido
    int indice = 0;
 //recorremos la matriz del cronograma
   for (int dia = 0; dia < cantDias; dia++ ){
        for (int hora = 0; hora < cantHorarios; hora++){
        //el elemento no puede ser nulo
        if(cronograma[dia][hora] != null){
       
        int poder = cronograma[dia][hora].calcularPoderTotal();
        //verificamos que este dentro del rango
            if(poder <= poderMax && poder >= poderMin){
            //si el duelo es valido lo guadamos en el arreglo de duelosEnRango
                duelosEnRango[indice] = cronograma[dia][hora];
                //avanzamos en al siguiente indice del arreglo
                indice++;
            }
        }
        
        }
    }
    //devuelve el arreglo
 return duelosEnRango;
}

public int cantDuelosEnRangoDePoder(int poderMin, int poderMax){
//inicializamos acumulador en 0
int cantDuelos = 0;
//recorremos la matriz
    for (int dia = 0; dia < cantDias; dia++ ){
        for (int hora = 0; hora < cantHorarios; hora++){
        //no tomamos en cuenta los elementos nulos
        if(cronograma[dia][hora] != null){
 //guardamos dentro de la variable poder el poder total del duelo en el que estamos parado la matriz
        int poder = cronograma[dia][hora].calcularPoderTotal();
         //verificamos que este dentro del rango
            if(poder <= poderMax && poder >= poderMin){
            //sumamos 1 al acumulador
            cantDuelos ++;
            }
        }
        
        }
    }
    //devolvemos la cantidadde duelos valids
return cantDuelos;
}

   /**
 * Guarda en un archivo de texto el contenido de un arreglo de duelos,
 * uno por linea, usando su representacion toString().
 *
 * @param duelos Arreglo de duelos a guardar.
 * @param rutaArchivo Ruta/nombre del archivo de salida.
 * @throws IOException Si ocurre un problema al escribir el archivo.
 */
public void guardarEnArchivo(Duelo[] duelos, String rutaArchivo) throws IOException {
       try (
           /*Se guarda en la variable bw para leer líneas completas.*/
       BufferedWriter bw = 
        /*El BufferedWritter envuelve al FileWritter para Escribir de forma más eficiente.*/
       new BufferedWriter(
       /*Busca el archivo cuya ruta está en rutaArchivo.Crea un objeto para escribir.*/
       new FileWriter(rutaArchivo))) {
           for (int i = 0; i <= duelos.length -1; i++) {
               bw.write(duelos[i].toString());
               bw.newLine();
           }
       }
   }


    // ==========================
    // FIN DEL TDA
    // ==========================
}
