public class Utilidades {
    
    public static int parseInteger (String numero){

        while (true) {
            try {
                int numeroEntero = Integer.parseInt(numero);
                return numeroEntero;
            } catch (Exception e) {
            System.out.println("Valor inválido");
            }
        }
    }
}
