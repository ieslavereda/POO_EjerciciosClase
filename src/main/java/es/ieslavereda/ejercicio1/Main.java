package es.ieslavereda.ejercicio1;

import es.ieslavereda.ejercicio2.TarjetaCredito;

public class Main {
    public static void main(String[] args) {

        Cuenta c1 = new Cuenta("Joaquin",3000);
        c1.ingreso(2000);

        TarjetaCredito tarjetaCredito = new TarjetaCredito(c1,c1.getTitular(),3000);

        System.out.println(tarjetaCredito.pagoCredito(100));

        System.out.println(tarjetaCredito);

        tarjetaCredito.saldarDeuda();

        System.out.println(tarjetaCredito);
    }
}
