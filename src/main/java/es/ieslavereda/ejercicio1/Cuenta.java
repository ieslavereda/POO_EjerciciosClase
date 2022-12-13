package es.ieslavereda.ejercicio1;

public class Cuenta {

    private static int siguiente = 0;
    private float saldo;
    private String numero;
    private String titular;

    public Cuenta(String titular) {
        this.titular = titular;
        this.numero = "0182-1234-34-" + siguiente;
        siguiente++;
    }
    public Cuenta(String titular, float saldo) {
        this(titular);

        this.saldo=saldo;
    }

    public boolean ingreso(float cantidad) {
        if (cantidad > 0) {
            this.saldo = this.saldo + cantidad;
            return true;
        }
        return false;
    }

    public boolean tranferencia(Cuenta destino,float cantidad){
        if(reintegro(cantidad)){
            if(destino.ingreso(cantidad))
                return true;
        }
        return false;
    }

    public String getNumero(){
        return numero;
    }
    public String getTitular(){
        return titular;
    }
    public float getSaldo(){
        return saldo;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public void setTitular(String titular){
        this.titular=titular;
    }
    public void setSaldo(float saldo){
        this.saldo=saldo;
    }

    public boolean reintegro(float cantidad){
        if(cantidad>0 && saldo>=cantidad) {
            this.saldo -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Titular: " + titular + "\n" +
                "Numero: " + numero + "\n" +
                "Saldo: " + saldo + " €";
    }

}
