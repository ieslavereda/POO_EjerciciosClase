package es.ieslavereda.Cartas;

import java.util.Scanner;

public class Entrada {
    public static final String YES = "Y";
    public static final String NO = "N";
    public static String getString(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        return scanner.nextLine();
    }
    public static String getOption(String text){
        String opcion = getString(text);
        while (!opcion.equals(YES) && !opcion.equals(NO))
            opcion = getString("Solo puedes contestar [Y|N].\n" + text);
        return opcion;
    }
    public static int getInt(String text){
        Scanner scanner = new Scanner(System.in);
        System.out.println(text);
        while (!scanner.hasNextInt()){
            System.out.println("Solo puedes introducir un numero.");
            System.out.println(text);
            scanner.next();
        }

        return scanner.nextInt();
    }
}
