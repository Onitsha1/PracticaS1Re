import java.time.LocalDate;

public class Partido {
    
    private LocalDate dia;
    private Equipo equipo1;
    private Equipo equipo2;
    private String resultado;

    public Partido(LocalDate dia, Equipo equipo1, Equipo equipo2, String resultado) {
        this.dia = dia;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.resultado = resultado;
    }

    public static void jugarPartido(){
        Equipo equipo1;
        Equipo equipo2;
        
        System.out.println("Escriba el nombre del equipo 1: ");
        String nombreEquipo1 = App.lector.nextLine();
        equipo1 = Liga.buscarEquipo(nombreEquipo1); 

        System.out.println("Escriba el nombre del equipo 2: ");
        String nombreEquipo2 = App.lector.nextLine();
        equipo2 = Liga.buscarEquipo(nombreEquipo2); 
                
        if (equipo1 == null || equipo2 == null){
            System.out.println("Uno o dos de los equipos introducidos no existen.");

        } else {
            int canastasEquipo1 = introducirCanastas(equipo1);
            int canastasEquipo2 = introducirCanastas(equipo2);
            LocalDate dia = LocalDate.now();
            String resultado = equipo1.getNombreEquipo() + ": " + canastasEquipo1 + " - " + equipo2.getNombreEquipo() +  ": " + canastasEquipo2;

            Partido partido = new Partido(dia, equipo1, equipo2, resultado);
            Liga.getPartidos().add(partido);
            Liga.agregarPuntos(canastasEquipo1, canastasEquipo2, equipo1, equipo2);
            }
    }

    public static int introducirCanastas (Equipo equipo){
        String canastasIntroducidas;
    
        System.out.println("Escriba el número de canastas para " + equipo.getNombreEquipo() + ": ");
        canastasIntroducidas = App.lector.nextLine();
        int canastas = Utilidades.parseInteger(canastasIntroducidas);
        return canastas; 
    }

    public LocalDate getDia() {
        return dia;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public String getResultado() {
        return resultado;
    }
    
    
}
