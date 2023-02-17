package es.ieslavereda.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {



        try(FileInputStream in = new FileInputStream("xanadu.txt");
                FileOutputStream out = new FileOutputStream("outagain.txt")) {

            int c;

            while ((c = in.read()) != -1) {
                System.out.println(c);
                out.write(c);
            }
        }
    }
}