public class Main {
    public static void main(String[] args) {
        Torneo torneo = new Torneo();
        torneo.cargarPersonajes("personajes.txt");
        torneo.cargarArmas("armas.txt");
        torneo.cargarArenas("arenas.txt");
        torneo.cargarDuelos("duelos.txt");

        Menu menu=new Menu(torneo);
        menu.iniciar();
    }
}