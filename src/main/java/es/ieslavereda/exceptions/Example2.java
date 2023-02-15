package es.ieslavereda.exceptions;

public class Example2 {

    public static void main(String[] args) throws MyCustomException {

        try {
            System.out.println(division(4, 0));
            System.out.println("Todo ok");
        }catch (Exception e){
            System.out.println("Se ha producido un error: " + e.getMessage());
            e.printStackTrace();
            throw new MyCustomException("Mi excepcion");
        }finally {
            System.out.println("Fin");
        }

    }

    private static int division(int numerador, int denominador) throws Exception {

        int numero ;

        if(denominador==0)
            throw new Exception("El denominador es 0.");

        numero = numerador/denominador;

        return numero;

    }
}
