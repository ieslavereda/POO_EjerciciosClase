package es.ieslavereda.Cartas;

public class Persona {

    public String nombre;
    public int edad;
    public String direccion;

    public  Persona (String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }
    public  Persona (String nombre, int edad,String direccion){
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }
    public Persona(){
        nombre="Desconocido";
    }

    public int getEdad(){
        return this.edad;
    }
    public void setEdad(int edad){
        this.edad=edad;
    }

    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String nuevaDireccion){
        this.direccion = nuevaDireccion;
    }

    public void cumplirAnyo(){
        edad++;
    }
    public String saluda(){
        return "Hola soy "+ nombre + " y tengo " + edad + " años.";
    }

    @Override
    public String toString(){
        return "Nombre: " + nombre+
                ", edad: " + edad +
                ", direccion: "+direccion;
    }
}
