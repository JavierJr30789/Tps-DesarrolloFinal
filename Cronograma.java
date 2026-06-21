
public class Cronograma {

    private Duelo[][] cronograma;
    private static final int cantDias = 7;
    private static final int cantHorarios = 15;

    public Cronograma() {
        this.cronograma = new Duelo[cantDias][cantHorarios];
    }

    public static int horaIndice(int hora) {
        return hora - 8;
    }

    public boolean existeDuelo(int numero) {
        boolean existe = false;
        if (buscarDuelo(numero) != null) {
            existe = true;
        }

        return existe;
    }

    public boolean horarioDisponible(int dia, int hora) {
        boolean disponible = false;
        int indice = horaIndice(hora);

        if (cronograma[dia][indice] == null) {
            disponible = true;
        }
        return disponible;
    }

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

    public boolean agregarDuelo(Duelo d) {
        boolean agregado = false;
        int indice = horaIndice(d.getHora());
        if (cronograma[d.getDia()][indice] == null) {
            cronograma[d.getDia()][indice] = d;
            agregado = true;
        }

        return agregado;
    }

    public Duelo getDuelo(int dia, int hora) {
        return cronograma[dia][horaIndice(hora)];
    }

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

    public int cantidadDuelosPorDia(int dia) {
        int cantidadDuelos = 0;

        for (int hora = 0; hora < cantHorarios; hora++) {
            if (cronograma[dia][hora] != null) {
                cantidadDuelos++;
            }
        }
        return cantidadDuelos;
    }
    //final del tda
}
