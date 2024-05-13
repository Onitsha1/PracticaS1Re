import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Liga {
    
    private static ArrayList<Partido> partidos = new ArrayList<>();
    private static ArrayList<Equipo> equipos = new ArrayList<>();
    

    public static Equipo buscarEquipo(String equipoBuscado){
        Equipo equipo = null;

        for (Equipo equipoEnLista : equipos){
            if (equipoEnLista.getNombreEquipo().equals(equipoBuscado)){
                equipo = equipoEnLista;
                return equipo;
            }
        }
        return equipo;
    }

    
    public static void agregarPuntos (int canastasEquipo1, int canastasEquipo2, Equipo equipo1, Equipo equipo2){
        int puntosEquipoGanador;

        if(Math.max(canastasEquipo1, canastasEquipo2)==canastasEquipo1){
            puntosEquipoGanador = equipo1.getPuntos() + 1;
            equipo1.setPuntos(puntosEquipoGanador);
            System.out.println("La nueva puntuación del equipo" + equipo1.getNombreEquipo() + " es: " + equipo1.getPuntos());
            return;

        } else {

            if(Math.max(canastasEquipo1, canastasEquipo2)==canastasEquipo2){
                puntosEquipoGanador = equipo2.getPuntos() + 1;
                equipo2.setPuntos(puntosEquipoGanador);
                System.out.println("La nueva puntuación del equipo " + equipo2.getNombreEquipo() + " es: " + equipo2.getPuntos());
                return;
            } else {
                System.out.println("Empate, no se añadirán puntos.");
            }
        }
    }

    public static void gestionarEquipo(Equipo equipo){
        boolean error = true;
        int opcion = -1;
        String opcionIntroducida;

        do {
        System.out.println("-- Gestión equipo --");
        System.out.println("1. Agregar entrenador");
        System.out.println("2. Agregar jugador a equipo");
        System.out.println("3. Ver jugador más alto");
        System.out.println("4. Ver lista entrenadores por antigüedad");
        System.out.println("5. Volver al menú principal");
        System.out.println("Escriba una de las anteriores opciones: ");
        opcionIntroducida = App.lector.nextLine();
        opcion = Utilidades.parseInteger(opcionIntroducida);

            if (opcion >= 1 && opcion <= 5){
                error = false;
            } else {
                System.out.println("Esa opción no existe.");
            }

            switch (opcion) {
                case 1:
                    Entrenador.agregarEntrenador(equipo);
                    break;

                case 2:
                    Jugador.agregarJugador(equipo);
                    break;

                case 3:
                    Equipo.alturaJugadoresEquipo(equipo);
                    break;

                case 4:
                    Entrenador.anioEntrenadores();
                    break;

                case 5:
                    App.menuPrincipal();
                    break;
            }

        } while (error || opcion != 5);
    
    }

    public static void verClasificacion (){
        int puesto = 1;

        Collections.sort(equipos, Comparator.comparingInt(Equipo::getPuntos).reversed());

        for (Equipo equipo : equipos){
            System.out.println("Puesto nº "+ puesto  + ": con " + equipo.getPuntos() + " puntos " +  equipo.getNombreEquipo() + " de: " + equipo.getCiudadEquipo());
            puesto++;
        }
    }

    public static void listaEquipos(){

        for (Equipo equipoEnLista : equipos){
            System.out.println("- " + equipoEnLista.getNombreEquipo() + " de: " + equipoEnLista.getCiudadEquipo());
        }
    }

    public static ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public static ArrayList<Equipo> getEquipos() {
        return equipos;
    }
}
