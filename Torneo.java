import java.io.BufferedReader; //abre el archivo.
import java.io.FileReader; //lee el contenido de forma eficiente.
import java.io.IOException;// captura cualquier error que ocurra durante la lectura.

public class Torneo {

    private Personaje[] personajes;
    private int cantPersonajes;

    private Arma[] armas;
    private int cantArmas;

    private Arena[] arenas;
    private int cantArenas;

    private Cronograma cronograma;

    public Torneo(String rutaPersonajes, String rutaArmas, String rutaArenas, String rutaDuelos) {
    /**
     * Constructor del Torneo.
     * Cuenta las lineas de cada archivo para crear los arreglos del tamaño exacto,
     * inicializa el cronograma y carga todos los datos (personajes, armas, arenas
     * y duelos) desde los archivos recibidos.
     * Si ocurre un error de lectura en cualquiera de los archivos, se atrapa la
     * excepcion y se informa por consola, dejando el torneo sin terminar de inicializar.
     *
     * @param rutaPersonajes ruta del archivo personajes.txt
     * @param rutaArmas      ruta del archivo armas.txt
     * @param rutaArenas     ruta del archivo arenas.txt
     * @param rutaDuelos     ruta del archivo duelos.txt
     */
        try {
            int cantLineasPersonajes = contarLineas(rutaPersonajes);
            personajes = new Personaje[cantLineasPersonajes];
            cantPersonajes = 0;

            int cantLineasArmas = contarLineas(rutaArmas);
            armas = new Arma[cantLineasArmas];
            cantArmas = 0;

            int cantLineasArenas = contarLineas(rutaArenas);
            arenas = new Arena[cantLineasArenas];
            cantArenas = 0;

            cronograma = new Cronograma();

            cargarPersonajes(rutaPersonajes);
            cargarArmas(rutaArmas);
            cargarArenas(rutaArenas);
            cargarDuelos(rutaDuelos);

        } catch (IOException e) {
            System.out.println("Error al inicializar el torneo: " + e.getMessage());
        }
    }

/**
     * Cuenta la cantidad de lineas de un archivo de texto.
     * Se usa antes de cargar los datos para saber el tamaño exacto que debe
     * tener el arreglo correspondiente (personajes, armas o arenas), evitando
     * crear arreglos mas grandes de lo necesario.
     *
     * @param rutaArchivo ruta del archivo a contar
     * @return cantidad de lineas que tiene el archivo
     * @throws IOException si el archivo no existe o no se puede leer
     */
    private int contarLineas(String rutaArchivo) throws IOException {
        int cantidad = 0;
        try (
        /*Se guarda en la variable br para leer líneas completas.*/
        BufferedReader br = 
        /*El BufferedReader envuelve al FileReader para leer de forma más eficiente.*/
        new BufferedReader(
        /*Busca el archivo cuya ruta está en rutaArchivo.Crea un objeto para leerlo.*/
        new FileReader(rutaArchivo))) {

        /*lee una línea del archivo. en cada iteracion */
            while (br.readLine() != null) {
                cantidad++;
            }
        }
        return cantidad;
    }

      /**
     * Carga los personajes desde el archivo recibido y los almacena en el
     * arreglo personajes. Cada linea del archivo representa un personaje completo,
     * con sus datos separados por ";". No valida los datos, se asume que son correctos.
     *
     * @param rutaArchivo ruta del archivo personajes.txt
     * @throws IOException si el archivo no existe o no se puede leer
     */

    private void cargarPersonajes(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
           Personaje nuevoPersonaje = new Personaje(
              datos[0],                      // codigo
              datos[1],                      // nombre
              datos[2],                      // tipo
              Integer.parseInt(datos[3]),    // nivelDeEnergia
              Integer.parseInt(datos[4]),    // cantDuelosGanados
              Integer.parseInt(datos[5])     // cantDuelosPerdidos
);

                //guarda el objeto del personaje en el arreglo
                personajes[cantPersonajes] = nuevoPersonaje;
                cantPersonajes++;//aumenta el tamaño del arreglo
            }
        }
    }

/**
     * Carga las armas desde el archivo recibido y las almacena en el arreglo armas.
     * Cada linea del archivo representa un arma completa, con sus datos separados
     * por ";". No valida los datos, se asume que son correctos.
     *
     * @param rutaArchivo ruta del archivo armas.txt
     * @throws IOException si el archivo no existe o no se puede leer
     */
private void cargarArmas(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                Arma nuevaArma = new Arma(
                datos[0], //codigo de arma
                datos[1], //nombre del arma
                datos[2], //tipo del arma
                Integer.parseInt(datos[3]), //nivel de poder
                Boolean.parseBoolean(datos[4])); // es magica o no
                // guarda el objeto arma dentro del arreglo
                armas[cantArmas] = nuevaArma;
                cantArmas++;//aumenta el tamaño del arreglo
            }
        }
    }

 /**
     * Carga las arenas desde el archivo recibido y las almacena en el arreglo arenas.
     * Cada linea del archivo representa una arena completa, con sus datos separados
     * por ";". No valida los datos, se asume que son correctos.
     *
     * @param rutaArchivo ruta del archivo arenas.txt
     * @throws IOException si el archivo no existe o no se puede leer
     */
    private void cargarArenas(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                Arena nuevaArena = new Arena(
                datos[0], //codigo de la arena
                datos[1], //nombre de la arena
                datos[2], // Ubicacion de la arena
                Integer.parseInt(datos[3]), //Cantidad de espectadores
                Integer.parseInt(datos[4])); //dificultad de la arena

                //guarda el objeto en el arreglo
                arenas[cantArenas] = nuevaArena;
                cantArenas++;//aumenta el tamaño del arreglo
            }
        }
    }


   /**
     * Carga los duelos desde el archivo recibido y los agrega al cronograma.
     * A diferencia de los otros metodos de carga, este no crea entidades nuevas
     * de Personaje, Arma o Arena: busca por codigo las que ya fueron cargadas
     * previamente (por eso debe ejecutarse despues de cargarPersonajes, cargarArmas
     * y cargarArenas) y con esas referencias construye cada Duelo.
     *
     * @param rutaArchivo ruta del archivo duelos.txt
     * @throws IOException si el archivo no existe o no se puede leer
     */
    private void cargarDuelos(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                //asignamos lo valores encontrados por linea, a variables locales
                int numero = Integer.parseInt(datos[0]); //codigo del duelo
                Personaje p1 = buscarPersonajePorCodigo(datos[1]); // primer personaje
                Personaje p2 = buscarPersonajePorCodigo(datos[2]); // segundo personaje
                Arma a1 = buscarArmaPorCodigo(datos[3]); //arma del primer personaje
                Arma a2 = buscarArmaPorCodigo(datos[4]); //arma del segundo personaje
                Arena unaArena = buscarArenaPorCodigo(datos[5]); // arena del duelo
                int dia = Integer.parseInt(datos[6]); //dia del duelo
                int hora = Integer.parseInt(datos[7]); //horario del duelo
                String estado = datos[8];// "programado" o "realizado"

                //creamos el nuevo objeto duelo
                Duelo nuevoDuelo = new Duelo(numero, p1, p2, a1, a2, unaArena, dia, hora, estado);

                // el cual lo guardamos dentro de la matriz del tda del cronograma
                cronograma.agregarDuelo(nuevoDuelo);
            }
        }
    }


  /**
     * Busca un personaje dentro del arreglo personajes segun su codigo.
     * Recorre el arreglo hasta encontrarlo o hasta llegar al final de los
     * elementos cargados (cantPersonajes).
     *
     * @param codigo codigo del personaje a buscar
     * @return el Personaje encontrado, o null si no existe ninguno con ese codigo
     */
    public Personaje buscarPersonajePorCodigo(String codigo) {
        Personaje encontrado = null;
        int i = 0;
        while (i < cantPersonajes && encontrado == null) {
            if (personajes[i].getCodigo().equals(codigo)) {
                encontrado = personajes[i];
            }
            i++;
        }
        return encontrado;
    }

   /**
     * Busca un arma dentro del arreglo armas segun su codigo.
     * Recorre el arreglo hasta encontrarla o hasta llegar al final de los
     * elementos cargados (cantArmas).
     *
     * @param codigo codigo del arma a buscar
     * @return el Arma encontrada, o null si no existe ninguna con ese codigo
     */
    public Arma buscarArmaPorCodigo(String codigo) {
        Arma encontrada = null;
        int i = 0;
        while (i < cantArmas && encontrada == null) {
            if (armas[i].getCodigo().equals(codigo)) {
                encontrada = armas[i];
            }
            i++;
        }
        return encontrada;
    }


/**
     * Busca una arena dentro del arreglo arenas segun su codigo.
     * Recorre el arreglo hasta encontrarla o hasta llegar al final de los
     * elementos cargados (cantArenas).
     *
     * @param codigo codigo de la arena a buscar
     * @return la Arena encontrada, o null si no existe ninguna con ese codigo
     */
    public Arena buscarArenaPorCodigo(String codigo) {
        Arena encontrada = null;
        int i = 0;
        while (i < cantArenas && encontrada == null) {
            if (arenas[i].getCodigo().equals(codigo)) {
                encontrada = arenas[i];
            }
            i++;
        }
        return encontrada;
    }
/**
 * Ordena los duelos de un dia determinado segun su poder total de
 * combate (de menor a mayor) y guarda el resultado en un archivo
 * de texto, tal como pide la funcionalidad 6 del enunciado.
 *
 * Delega el ordenamiento y el guardado al Cronograma, ya que es
 * quien tiene acceso directo a la matriz de duelos.
 *
 * @param dia Dia a consultar y ordenar.
 * @param rutaArchivo Ruta/nombre del archivo donde se guarda el resultado.
 * @return Arreglo de duelos del dia, ya ordenado por poder total.
 * @throws IOException Si ocurre un problema al escribir el archivo.
 */
public Duelo[] guardarDuelosOrdenados(int dia, String rutaArchivo) throws IOException {

    Duelo[] duelosOrdenados = cronograma.ordenarDuelosPorDia(dia);

    cronograma.guardarEnArchivo(duelosOrdenados, rutaArchivo);

    return duelosOrdenados;
}
 
 /**
 * Calcula la cantidad total de duelos realizados en todo el cronograma,
 * utilizando el metodo recursivo del Cronograma.
 *
 * @return Cantidad de duelos realizados.
 */
public int contarDuelosRealizados() {
    return cronograma.duelosRealizados(0, 0, 0);
}

/**
 * Agrega un nuevo duelo al cronograma, validando todas las reglas
 * que pide el enunciado antes de crearlo.
 *
 * Controla que: el numero no este repetido, los personajes/armas/arena
 * existan, los personajes sean diferentes, el horario este entre 08 y 22,
 * el dia/horario este disponible y ninguno de los personajes participe
 * en otro duelo ese mismo dia.
 *
 * @param numero numero del nuevo duelo
 * @param codP1 codigo del primer personaje
 * @param codP2 codigo del segundo personaje
 * @param codA1 codigo del arma del primer personaje
 * @param codA2 codigo del arma del segundo personaje
 * @param codArena codigo de la arena
 * @param dia dia de la semana (0=Lunes ... 6=Domingo)
 * @param hora hora real (08 a 22 inclusive)
 * @return true si se pudo agregar, false si alguna validacion fallo
 */
public boolean agregarDuelo(int numero, String codP1, String codP2,
                             String codA1, String codA2, String codArena,
                             int dia, int hora) {

    boolean resultado = false;

    // 1. Horario dentro del rango permitido
    if (hora >= 8 && hora <= 22) {

        // 2. Numero de duelo no repetido
        if (!cronograma.existeDuelo(numero)) {

            Personaje p1 = buscarPersonajePorCodigo(codP1);
            Personaje p2 = buscarPersonajePorCodigo(codP2);
            Arma a1 = buscarArmaPorCodigo(codA1);
            Arma a2 = buscarArmaPorCodigo(codA2);
            Arena unaArena = buscarArenaPorCodigo(codArena);

            // 3. Personajes, armas y arena existentes
            if (p1 != null && p2 != null && a1 != null && a2 != null && unaArena != null) {

                // 4. Personajes diferentes
                if (!p1.getCodigo().equals(p2.getCodigo())) {

                    // 5. Horario disponible
                    if (cronograma.horarioDisponible(dia, hora)) {

                        // 6. Ninguno de los personajes ocupado ese dia
                        if (!cronograma.personajeOcupadoEseDia(codP1, dia) &&
                            !cronograma.personajeOcupadoEseDia(codP2, dia)) {

                            Duelo nuevoDuelo = new Duelo(numero, p1, p2, a1, a2, unaArena, dia, hora,"programado");
                            resultado = cronograma.agregarDuelo(nuevoDuelo);
                        }
                    }
                }
            }
        }
    }

    return resultado;
}
   //final del tda
}