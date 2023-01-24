package es.ieslavereda.ejercicio5;

public abstract class Empleado {
    private String nombre;
    private String apellidos;
    private String DNI;
    private String direccion;
    private int antiguedad;
    private String telefono;
    protected float salario;
    private Empleado supervisor;

    public Empleado(String nombre, String apellidos, String DNI, String direccion, String telefono, float salario) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.DNI = DNI;
        this.direccion = direccion;
        this.telefono = telefono;
        this.salario = salario;
        this.antiguedad = 0;
        this.supervisor = null;
    }

    public void setSupervisor(Empleado supervisor) {
        this.supervisor = supervisor;
    }

    public void incrementarAntiguedad(){
        antiguedad++;
        incrementarSarlario();
    }

    public abstract void incrementarSarlario();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Empleado) {
            Empleado e = (Empleado) obj;
            return e.DNI.compareToIgnoreCase(DNI)==0;
        }
        return false;
    }


    @Override
    public String toString() {
        return  "nombre='" + nombre + '\'' + "\n"+
                ", apellidos='" + apellidos + '\'' +"\n"+
                ", DNI='" + DNI + '\'' +"\n"+
                ", direccion='" + direccion + '\'' +"\n"+
                ", antiguedad=" + antiguedad +"\n"+
                ", telefono='" + telefono + '\'' +"\n"+
                ", salario=" + salario +"\n"+
                ", supervisor=" + supervisor +"\n";
    }
}
