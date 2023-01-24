package es.ieslavereda.ejercicio5;

public class Secretario extends Empleado{

    private String despacho;
    private String fax;

    public Secretario(String nombre, String apellidos, String DNI, String direccion, String telefono, float salario, String despacho, String fax) {
        super(nombre, apellidos, DNI, direccion, telefono, salario);
        this.despacho = despacho;
        this.fax = fax;
    }

    @Override
    public void incrementarSarlario() {
        salario+=salario*0.05;
    }

    @Override
    public String toString() {
        return "Secreatario:\n"+
                super.toString() + "\n"+
                "despacho: " + despacho +"\n"+
                "fax: " + fax;
    }
}
