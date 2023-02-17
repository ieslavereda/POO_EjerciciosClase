package es.ieslavereda.streams;

import es.ieslavereda.Cartas.*;

import java.io.*;

public class CopyObject {
    public static void main(String[] args) {
        save();
        load();
    }

    private static void load()  {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("objectcopy.txt"))){


            BarajaTAD b = (BarajaTAD) ois.readObject();
            Carta c = (Carta) ois.readObject();
            System.out.println(b);
            System.out.println(c);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void save()  {
        BarajaTAD b = new BarajaTAD();
        Carta c = new Carta(Valor.A, Palo.HEART);
        b.shuffle();
        System.out.println(b);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("objectcopy.txt"))){

            oos.writeObject(b);
            oos.writeObject(c);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
