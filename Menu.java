
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    private Torneo torneo;
    private Scanner sc;

    // constructor
    public Menu(Torneo torneo) {
        this.torneo = torneo;
        this.sc = new Scanner(System.in);
    }
// limpia visualmente la consola
private void limpiarPantalla() {
    for (int i = 0; i < 50; i++) {
        System.out.println();
    }
}

// espera que el usuario presione ENTER
private void pausar() {
    System.out.println("\nPresione ENTER para volver al menú...");
    sc.nextLine();
}
    // bucle del menu
    public void iniciar() {
    int opcion;
    boolean salir = false;

    do {
        limpiarPantalla();

    while (true) {
    //el usuario ingresa cualquier valor, sea string o int lo pasamos como un string, en la variable entrada
        String entrada = sc.nextLine();
// intenta transformar a entero el valor de entrada
        try {
            opcion = Integer.parseInt(entrada);
            break;

            // si el valor que intentamos transformar no puede ser convertido a entero, "atrapa" el error de java NumberFormat exeption
        } catch (NumberFormatException e) {
        // no sale del sistema y sigue preguntando hasta que el usuario ingrese una opcion valida
            System.out.print("Debe ingresar un número entre 0 y 9. Intente nuevamente: ");
        }
    }

        limpiarPantalla();

        switch (opcion) {
            case 1:
                opcionAgregarPersonaje();
                break;
            case 2:
                opcionAgregarDuelo();
                break;
            case 3:
                opcionMarcarRealizado();
                break;
            case 4:
                opcionDuelosRealizados();
                break;
            case 5:
                opcionOrdenarDuelosDelDia();
                break;
            case 6:
                opcionMostrarPersonaje();
                break;
            case 7:
                opcionDuelosEnRangoDePoder();
                break;
            case 8:
                opcionHorariosLibres();
                break;
            case 9:
                opcionPrimerDueloMagico();
                break;
            case 0:
                salir = true;
                System.out.println("Gracias por usar el sistema!");
                break;
            default:
                System.out.println("La opcion elegida no es valida");
                break;
        }

        if (!salir) {
            pausar();
        }

    } while (!salir);
}
    // mostrar opciones
    private void mostrarOpciones() {
        System.out.println("\n=====================================");
        System.out.println("        SISTEMA DE TORNEOS DE DUELOS ");
        System.out.println("=====================================");
        System.out.println(" 1) Agregar personaje");
        System.out.println(" 2) Agregar duelo");
        System.out.println(" 3) Marcar duelo como realizado");
        System.out.println(" 4) Ver cantidad de duelos realizados");
        System.out.println(" 5) Mostrar duelos de un día ordenados");
        System.out.println(" 6) Mostrar datos de un personaje");
        System.out.println(" 7) Obtener duelos por rango de poder");
        System.out.println(" 8) Mostrar cantidad de horarios libres");
        System.out.println(" 9) Mostrar primer duelo con arma mágica por día");
        System.out.println(" 0) Salir");
        System.out.println("=====================================");
        System.out.print("Seleccione una opción: ");
    }

    // metodo de la primera opcion para agregar un personaje
    private void opcionAgregarPersonaje() {
        System.out.print("Ingrese el codigo del personaje: ");
        String codigo = sc.nextLine();
        System.out.print("Ingrese el nombre del personaje: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el tipo del personaje (guerrero, mago, arquero, etc): ");
        String tipo = sc.nextLine();
        System.out.print("Ingrese el nivel de energia del personaje: ");
        int nivelEnergia = sc.nextInt();
        sc.nextLine();
     

        boolean agregado = torneo.agregarPersonaje(codigo, nombre, tipo, nivelEnergia);

        if (agregado) {
            System.out.println("Personaje agregado con exito.");
        } else {
            System.out.println("No se pudo agregar el personaje.");
        }
    }

    // metodo de la opcion 2 para agregar un duelo
    private void opcionAgregarDuelo() {
        System.out.print("Número de duelo: ");
        String numero = sc.nextLine();
        System.out.print("Código del primer personaje: ");
        String codPer1 = sc.nextLine();
        System.out.print("Código del segundo personaje: ");
        String codPer2 = sc.nextLine();
        System.out.print("Código del arma del primer personaje: ");
        String codArm1 = sc.nextLine();
        System.out.print("Código del arma del segundo personaje: ");
        String codArm2 = sc.nextLine();
        System.out.print("Código de la arena: ");
        String codArena = sc.nextLine();
        System.out.print("Día (0=Lunes ... 6=Domingo): ");
        int dia = sc.nextInt();
        System.out.print("Hora (08 a 22): ");
        int hora = sc.nextInt();
        sc.nextLine();

        boolean agregado = torneo.agregarDuelo(numero, codPer1, codPer2, codArm1, codArm2, codArena, dia, hora);
        if (agregado) {
            System.out.println("Duelo agregado con exito.");
        } else {
            System.out.println("No se pudo agregar el duelo (alguna validación falló).");
        }
    }

//metodo de la opcion 3 que maraca un duelo como realizado
    private void opcionMarcarRealizado() {
        System.out.println("Numero de duelo: ");
        String numero = sc.nextLine();
        System.out.println("Codigo del personaje ganador: ");
        String codGanador = sc.nextLine();

        if (torneo.marcarDueloRealizado(numero, codGanador)) {
            System.out.println("Duelo marcado como realizado");
        } else {
            System.out.println("Error: duelo inexistente, personaje inexistente, ya realizado, o ganador invalido");
        }
    }

    // metodo de la opcion 4 que muestra la cantidad de duelos realizados
    private void opcionDuelosRealizados() {
        System.out.println("\n==============================");
        System.out.println("   DUELOS REALIZADOS EN TOTAL ");
        System.out.println("==============================");
        System.out.println("Cantidad: " + torneo.contarDuelosRealizados());
    }

    //metodo de la opcion 5 que genera un archivo txt con todos los duelos guardados en orden de mayor a menor segun su el nivel de poder total
private void opcionOrdenarDuelosDelDia() {
    System.out.println("Dia (0=Lunes...6=Domingo): ");
    int dia = sc.nextInt();

    try {
        Duelo[] duelos = torneo.guardarDuelosOrdenados(dia, "duelos_dia_" + dia + ".txt");

        if (duelos.length == 0) {
            System.out.println("No hay duelos programados ese dia");
        } else {
            for (int i = 0; i < duelos.length-1 ; i++) {
                System.out.println(duelos[i].toString() + " - Poder: " + duelos[i].calcularPoderTotal());
            }
            System.out.println("Resultado guardado en archivo");
        }
 
    } catch (IOException e) {
        System.out.println("Error al guardar el archivo: " + e.getMessage());
    }
}
    
    //metodo para la opcion 6 que muestra el personaje ingresado por consola
    public void opcionMostrarPersonaje() {
    System.out.print("Ingrese el código del personaje: ");
    String codigo = sc.nextLine();
    if(!torneo.formatoCodigoValido(codigo)) {
        System.out.println("Error: El formato del código es inválido");
    } else {
        Personaje personaje = torneo.buscarPersonajePorCodigo(codigo);
        if(personaje == null) {
            System.out.println("Error: No existe un personaje con ese código");
        } else {
            System.out.println(personaje.toString());
        }
    }
}

        //metodo para la opcion 7 que muestra los duelos en un rango de poder
    public void opcionDuelosEnRangoDePoder() {
        System.out.print("Ingrese el poder minimo: ");
        int poderMin = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese el poder maximo: ");
        int poderMax = sc.nextInt();
        sc.nextLine();

        Duelo[] duelosEnRango = torneo.obtenerDuelosEnRangoDePoder(poderMin, poderMax);

        if (duelosEnRango.length == 0) {
            System.out.println("No se encontraron duelos en ese rango");
        } else {
            for (int i=0; i<duelosEnRango.length; i++) {
                System.out.println(duelosEnRango[i].toString());
            }
        }
    }
    
    // metodo de la opcion 8 que muestra la cantidad de horarios libres
    private void opcionHorariosLibres() {
        System.out.println("\n==============================");
        System.out.println("   HORARIOS LIBRES EN LA SEMANA");
        System.out.println("==============================");
        System.out.println("Cantidad: " + torneo.contarHorariosLibres());
    }

    // metodo de la opcion 9 que muestra el primer horario de cada dia con un arma magica
    private void opcionPrimerDueloMagico() {
        int[] horarios = torneo.primerDueloConArmaMagica();

        System.out.println("\n==============================");
        System.out.println(" PRIMER DUELO CON ARMA MÁGICA ");
        System.out.println("==============================");

        for (int i = 0; i < horarios.length; i++) {
            if (horarios[i] == -1) {
                System.out.println("dia " + (i + 1) + ": No hubo ningun duelo con arma magica este dia");
            } else {
                System.out.println("Dia " + (i + 1) + ": El primer duelo donde se uso un arma magica fue en el horario: " + horarios[i]);
            }
        }
    }

}
