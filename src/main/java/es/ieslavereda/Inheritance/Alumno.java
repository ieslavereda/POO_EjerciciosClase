package es.ieslavereda.Inheritance;

public class Alumno extends Persona{

    private String NIA;

    public Alumno(String nombre,String apellidos,String NIA){
        super(nombre,apellidos);
        this.NIA = NIA;
    }

    @Override
    public String toString(){
        //return super.toString() + "NIA: " + NIA;
        return "Alumno{" +
                "nombre: " + nombre +","+
                "apellidos: " + apellidos +","+
                "NIA: " + NIA+"}";
    }
}
