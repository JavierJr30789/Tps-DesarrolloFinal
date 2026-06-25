import java.util.Scanner;

public class Menu {
    private Torneo torneo;
    private Scanner sc;

    // constructor
    public Menu(Torneo torneo) {
        this.torneo = torneo;
        this.sc = new Scanner(System.in);
    }

    // bucle del menu
    public void iniciar() {
        int opcion;
        boolean salir = false;

        do {
            mostrarOpciones();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    opcionAgregarPersonaje();
                    break;
                case 2:
                    break;
                case 3:
                    opcionMarcarRealizado();
                    break;
                case 4:
                    opcionDuelosRealizados();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
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
                    break;
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
    public void opcionAgregarPersonaje() {
        System.out.print("Ingrese el codigo del personaje: ");
        String codigo = sc.nextLine();
        System.out.print("Ingrese el nombre del personaje: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el tipo del personaje (guerrero, mago, arquero, etc): ");
        String tipo = sc.nextLine();
        System.out.print("Ingrese el nivel de energia del personaje: ");
        int nivelEnergia = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese la cantiadad de duelos ganados del personaje: ");
        int deulGana = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese la cantidad de duelos perdidos del personaje: ");
        int duelPer = sc.nextInt();
        sc.nextLine();

        boolean agregado = torneo.agregarPersonaje(codigo, nombre, tipo, nivelEnergia, deulGana, duelPer);

        if (agregado) {
            System.out.println("Personaje agregado con exito.");
        } else {
            System.out.println("No se pudo agregar el personaje.");
        }
    }

    // metodo de la opcion 2 para agregar un duelo
    public void opcionAgregarDuelo() {
        System.out.print("Número de duelo: ");
        String numero = sc.nextLine();
        sc.nextLine();
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
    public void opcionDuelosRealizados() {
        System.out.println("\n==============================");
        System.out.println("   DUELOS REALIZADOS EN TOTAL ");
        System.out.println("==============================");
        System.out.println("Cantidad: " + torneo.contarDuelosRealizados());
    }

    // metodo de la opcion 8 que muestra la cantidad de horarios libres
    public void opcionHorariosLibres() {
        System.out.println("\n==============================");
        System.out.println("   HORARIOS LIBRES EN LA SEMANA");
        System.out.println("==============================");
        System.out.println("Cantidad: " + torneo.contarHorariosLibres());
    }

    // metodo de la opcion 9 que muestra el primer horario de cada dia con un arma magica
    public void opcionPrimerDueloMagico() {
        
    }

}
