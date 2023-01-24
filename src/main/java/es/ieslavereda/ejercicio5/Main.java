package es.ieslavereda.ejercicio5;

public class Main {
    public static void main(String[] args) {
        Vendedor empleado = new Vendedor("Joaquin","Alonso","1234","Mi casa","62222222",1000f,new Vehiculo("12345BBB","Seat","Ibiza"),"634333","Valencia",3);
        empleado.addClient("Luis");
        empleado.addClient("Manolo");
        empleado.addClient("Carlos");
        empleado.bajaCliente("Luis");

        empleado.incrementarSarlario();
        System.out.println(empleado);

    }
}
