public class Main {
    public static void main(String[] args) {
        Torneo torneo = new Torneo("personajes.txt", "armas.txt", "arenas.txt", "duelos.txt");

        Menu menu = new Menu(torneo);
        menu.iniciar();
    }
}