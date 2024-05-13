import java.util.Scanner;

public class App {
    static Scanner lector = new Scanner (System.in);
    public static void main(String[] args) throws Exception {
        
        menuPrincipal();
    }

    public static void menuPrincipal(){
        boolean error = true;
        int opcion = -1;
        String opcionIntroducida;

        do {
            System.out.println("-- Menu Principal --");
            System.out.println("1. Alta equipo");
            System.out.println("2. Baja equipo");
            System.out.println("3. Gestionar equipo");
            System.out.println("4. Jugar Partido");
            System.out.println("5. Ver lista de equipos en la clasificación");
            System.out.println("6. Lista de jugadores por altura");
            System.out.println("7. Salir");
            System.out.println("Escriba una de las opciones anteriores: ");
            opcionIntroducida = lector.nextLine();
            opcion = Utilidades.parseInteger(opcionIntroducida);

            if (opcion >= 1 && opcion <= 7){
                error = false;
            } else {
                System.out.println("Esa opción no existe.");
            }

            switch (opcion) {
                case 1:
                    Equipo.altaEquipo();
                    break;

                case 2:
                    Equipo.bajaEquipo();
                    break;

                case 3:
                    Equipo.seleccionarEquipo();
                    break;

                case 4:
                    Partido.jugarPartido();
                    break;

                case 5:
                    Liga.verClasificacion();
                    break;
            }
        } while (error || opcion != 7);
    }
}
