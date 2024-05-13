import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Entrenador extends Persona {

    private int anioLicencia;

    public Entrenador(String nombre, String apellidos, int anioLicencia) {
        super(nombre, apellidos);
        this.anioLicencia = anioLicencia;
    }

    public static void agregarEntrenador(Equipo equipo) {

        int anioLicencia;
        Entrenador entrenador = equipo.getEntrenador();

        if (entrenador == null){
            System.out.println("Escriba el nombre del entrenador: ");
            String nombre = App.lector.nextLine();
            System.out.println("Escriba el apellido del entrenador: ");
            String apellido = App.lector.nextLine();
            System.out.println("Escriba el año de licencia del entrenador: ");
            String anioLicenciaIntroducida = App.lector.nextLine();
            anioLicencia = Utilidades.parseInteger(anioLicenciaIntroducida);

            entrenador = new Entrenador(nombre, apellido, anioLicencia);
            equipo.setEntrenador(entrenador);
            
        } else {
            System.out.println("Este equipo ya tiene entrenador");
        }
    }

    public static void anioEntrenadores () {
        ArrayList <Entrenador> entrenadores = new ArrayList<>();
        
        for (Equipo equipo : Liga.getEquipos()) {
            entrenadores.add(equipo.getEntrenador());
        }
        Collections.sort(entrenadores, Comparator.comparing(Entrenador::getAnioLicencia));
        for (Entrenador entrenador : entrenadores) {
            System.out.println("El año de licencia del entrenador " + entrenador.getNombreEntrenador() + " " + entrenador.getApellidoEntrenador() + " es " + entrenador.getAnioLicencia());
        }
    }

    public String getNombreEntrenador(){
        return nombre;
    }

    public String getApellidoEntrenador(){
        return apellido;
    }
    public int getAnioLicencia() {
        return anioLicencia;
    }
}