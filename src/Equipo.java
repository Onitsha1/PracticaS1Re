import java.util.ArrayList;

class Equipo {

    private String nombreEquipo;
    private String ciudadEquipo;
    private Entrenador entrenador;
    private ArrayList<Jugador> jugadores;
    private int puntos;

    public Equipo(String nombreEquipo, String ciudadEquipo) {
        this.nombreEquipo = nombreEquipo;
        this.ciudadEquipo = ciudadEquipo;
        entrenador = null;
        jugadores = new ArrayList<>();
        puntos = 0;
    }

    public static void altaEquipo() {
        String nombreEquipo;
        String nombreCiudad;
        Equipo equipo = null;

        System.out.println("Escriba el nombre del equipo: ");
        nombreEquipo = App.lector.nextLine();
        equipo = Liga.buscarEquipo(nombreEquipo);

        if (equipo == null){

            System.out.println("Escriba el nombre de la ciudad del equipo: ");
            nombreCiudad = App.lector.nextLine();
            equipo = new Equipo (nombreEquipo, nombreCiudad);
            Liga.getEquipos().add(equipo);
            System.out.println("Equipo agregado correctamente.");

        } else {
            System.out.println("Ese equipo ya existe");
        }
    }

    public static void bajaEquipo () {

        String equipoBorrar;
        System.out.println("Lista de equipos: \n");
        for (Equipo equipo: Liga.getEquipos()) {
            System.out.println("- Equipo: " + equipo.getNombreEquipo() + " de " + equipo.getCiudadEquipo());
        }

        System.out.println("Escriba el nombre del equipo que desea borrar.");
        equipoBorrar = App.lector.next();

        for (Equipo equipo : Liga.getEquipos()) {
            if (equipo.getNombreEquipo().equals(equipoBorrar)) {
                Liga.getEquipos().remove(equipo);
                System.out.println("Equipo eliminado correctamente.");
                return;
            }
        }
        System.out.println("Ese equipo no existe.");
        return;
    }

    public static void seleccionarEquipo(){
        Equipo equipo = null;
        String equipoBuscado;

        Liga.listaEquipos();

        System.out.println("Escriba el nombre del equipo");
        equipoBuscado = App.lector.nextLine();
        equipo = Liga.buscarEquipo(equipoBuscado);

        if (equipo != null){
            Liga.gestionarEquipo(equipo);
        }
    }


    public static void alturaJugadoresEquipo (Equipo equipo) {
        Jugador jugadorMasAlto = null;

        for(Jugador jugador : equipo.getJugadores()){
            if(jugadorMasAlto == null){
                jugadorMasAlto = jugador;
            }
            else {
                if (jugadorMasAlto.getAlturaJugador() < jugador.getAlturaJugador()) {
                    jugadorMasAlto = jugador;
                }
            }
        }
        System.out.println("El jugador más alto es " + jugadorMasAlto.getDorsalJugador() + " " + "con " + jugadorMasAlto.getAlturaJugador() + " cm.");
    }


    public static Jugador buscarJugador(int dorsalBuscado){
        Jugador jugador = null;

        for (Equipo equipo : Liga.getEquipos())
            for (Jugador jugadorEnLista : equipo.getJugadores()){
                if (jugadorEnLista.getDorsalJugador().equals(dorsalBuscado)){
                    return jugador;
                }
        }
        return jugador;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public String getCiudadEquipo() {
        return ciudadEquipo;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public int getPuntos() {
        return puntos;
    }
}