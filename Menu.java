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
                case 1: opcionAgregarPersonaje();
                    break;
                case 2: 
                    break;
                case 3: 
                    break;
                case 4: 
                    break;
                case 5: 
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
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

    //metodo de la primera opcion para agregar un personaje
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
        int duelGana = sc.nextInt();
        sc.nextLine();
        System.out.print("Ingrese la cantidad de duelos perdidos del personaje: ");
        int duelPer = sc.nextInt();
        sc.nextLine();

        boolean agregado = torneo.agregarPersonaje(codigo, nombre, tipo, nivelEnergia, duelGana, duelPer);

        if (agregado) {
            System.out.println("Personaje agregado con exito.");
        } else {
            System.out.println("No se pudo agregar el personaje.");
        }
    }



}
