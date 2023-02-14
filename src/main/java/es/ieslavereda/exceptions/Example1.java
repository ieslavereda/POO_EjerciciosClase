package es.ieslavereda.exceptions;

public class Example1 {
    public static void main(String[] args) {

        int a,b,c;

        a=5;
        b=0;

        try {

            c = a / b;
            System.out.println(c);

        } catch (ArithmeticException e){
            System.out.println("Se ha producido un error");
        }catch (Exception e){
            System.out.println("Se ha producido un error");
        }




    }
}
