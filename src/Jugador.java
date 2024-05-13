public class Jugador extends Persona {

    private int dorsal;
    private int altura;
    private int peso;

    public Jugador (String nombre, String apellidos, int dorsal, int altura, int peso){
        super(nombre, apellidos);
        this.dorsal = dorsal;
        this.altura = altura;
        this.peso = peso;
    }
    
    public static void agregarJugador(Equipo equipo) {

        Jugador jugador = null;

        System.out.println("Escriba el dorsal del jugador: ");
        String dorsalIntroducido = App.lector.nextLine();
        int dorsal = Utilidades.parseInteger(dorsalIntroducido);
        jugador = Equipo.buscarJugador(dorsal);

        if (jugador == null){
            System.out.println("Escriba el nombre del jugador: ");
            String nombre = App.lector.nextLine();
            System.out.println("Escriba el apellido del jugador: ");
            String apellido = App.lector.nextLine();
            System.out.println("Escriba la altura del jugador en centímetros: ");
            String alturaIntroducida = App.lector.nextLine();
            int altura = Utilidades.parseInteger(alturaIntroducida);
            System.out.println("Escriba el peso del jugador en kilogramos: ");
            String pesoIntroducido = App.lector.nextLine();
            int peso = Utilidades.parseInteger(pesoIntroducido);

            jugador = new Jugador(nombre, apellido, dorsal, altura, peso);
            equipo.getJugadores().add(jugador);
            
        } else {
            System.out.println("Ese jugador ya existe");
        }
    }


    public String getNombreJugador() {
        return nombre;
    }

    public String getApellidoJugador () {
        return apellido;
    }

    public Integer getAlturaJugador() {
        return altura;
    }
    public Integer getDorsalJugador() {
        return dorsal;
    }

    public Integer getPesoJugador() {
        return peso;
    }
}
