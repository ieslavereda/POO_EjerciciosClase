package es.ieslavereda.ejercicio5;

public class JefeZona extends Empleado{
    private String despacho;
    private Secretario secretario;
    private Vendedor[] vendedores;
    private Vehiculo vehiculo;

    public JefeZona(String nombre, String apellidos, String DNI, String direccion, String telefono, float salario, String despacho) {
        super(nombre, apellidos, DNI, direccion, telefono, salario);
        this.despacho = despacho;
        vendedores = new Vendedor[0];
        vehiculo = null;
        secretario = null;
    }

    public void setSecretario(Secretario secretario) {
        this.secretario = secretario;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void add(Vendedor vendedor){

    }
    public void remove(Vendedor vendedor){
        boolean encontrado=false;
        int i=0;
        while(i < vendedores.length &&  !encontrado){
            if(vendedores[i].equals(vendedor))
                encontrado=true;
            else
                i++;
        }

        if(encontrado){
            Vendedor[] aux = new Vendedor[vendedores.length-1];
            for(int j=0;j<i;j++)
                aux[j]=vendedores[j];

            for(int j=i+1;j < vendedores.length;j++)
                aux[j-1]=vendedores[j];

            vendedores =aux;
        }
    }

    @Override
    public void incrementarSarlario() {
        salario+=salario*0.2;
    }
}
