package es.ieslavereda.ejercicio5;

import java.util.Arrays;

public class Vendedor extends Empleado{

    private Vehiculo vehiculo;
    private String telefonoMovil;
    private String area;
    private String[] clientes;
    private float comision;

    public Vendedor(String nombre, String apellidos, String DNI, String direccion, String telefono, float salario, Vehiculo vehiculo, String telefonoMovil, String area, float comision) {
        super(nombre, apellidos, DNI, direccion, telefono, salario);
        this.vehiculo = vehiculo;
        this.telefonoMovil = telefonoMovil;
        this.area = area;
        this.comision = comision;
        clientes = new String[0];
    }
    public void bajaCliente(String cliente){
        boolean encontrado=false;
        int i=0;
        while(i < clientes.length &&  !encontrado){
            if(clientes[i].compareToIgnoreCase(cliente)==0)
                encontrado=true;
            else
                i++;
        }

        if(encontrado){
            String[] aux = new String[clientes.length-1];
            for(int j=0;j<i;j++)
                aux[j]=clientes[j];

            for(int j=i+1;j < clientes.length;j++)
                aux[j-1]=clientes[j];

            clientes =aux;
        }

    }
    public void addClient(String o){

        String[] aux = new String[clientes.length+1];

        aux[0] = o;
        for(int i=1;i<aux.length;i++)
            aux[i]=clientes[i-1];

       clientes = aux;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public void incrementarSarlario() {
        salario+=salario*0.1;
    }

    @Override
    public String toString() {
        return "Vendedor{" +"\n"+
                super.toString()+"\n"+
                "vehiculo=" + vehiculo +
                ", telefonoMovil='" + telefonoMovil + '\'' +"\n"+
                ", area='" + area + '\'' +"\n"+
                ", clientes=" + Arrays.toString(clientes) +"\n"+
                ", comision=" + comision +"\n"+
                '}';
    }


}
