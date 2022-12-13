package es.ieslavereda.ejercicio2;

import es.ieslavereda.ejercicio1.Cuenta;

public class TarjetaCredito {

    private static int siguiente = 0;

    private Cuenta cuentaAsociada;
    private String numero;
    private String titular;
    private float saldo;
    private float saldoInicial;

    public TarjetaCredito(Cuenta cuentaAsociada,String titular,float saldoInicial){
        this.cuentaAsociada = cuentaAsociada;
        this.titular = titular;
        this.saldoInicial = saldoInicial;
        this.numero = "2342 2341 5345 " + siguiente++;
        this.saldo = saldoInicial;
    }
    public TarjetaCredito(Cuenta cuentaAsociada,float saldoInicial){
        this.cuentaAsociada = cuentaAsociada;
        this.titular = cuentaAsociada.getTitular();
        this.saldoInicial = saldoInicial;
        this.numero = "2342 2341 5345 " + siguiente++;
        this.saldo = saldoInicial;
    }

    public boolean pagoCredito(float cantidad){
        if(cantidad<=saldo && cantidad>0){
            saldo = saldo - cantidad;
            return true;
        }

        return false;
    }

    public boolean saldarDeuda(){
         if(cuentaAsociada.reintegro(saldoInicial-saldo)) {
             saldo = saldoInicial;
             return true;
         }
         return false;
    }

    public boolean pagoDebito(float cantidad){
        return cuentaAsociada.reintegro(cantidad);
    }

    @Override
    public String toString(){
        return  "Titular: " + titular + "\n" +
                "Saldo cuenta:" + cuentaAsociada.getSaldo() + "\n" +
                "Numero tarjeta: " + numero+ "\n" +
                "Credito: " + saldo + "\n" +
                "Credito Inicial: " + saldoInicial;
    }
}
