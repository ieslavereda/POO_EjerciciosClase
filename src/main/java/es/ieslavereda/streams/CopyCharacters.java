package es.ieslavereda.streams;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {

        try (FileReader inputStream= new FileReader("xanadu.txt");
             FileWriter outputStream = new FileWriter("characteroutput.txt");) {

            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
        }
    }
}