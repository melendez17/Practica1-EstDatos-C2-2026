package colaDinamica;
import listaEnlazada.Ticket;

import java.util.ArrayList;

public class ColaPrioridad {

    //Atributos
    private ArrayList<Ticket> elementos;

    //Métodos
    //constructor
    public ColaPrioridad() {
        elementos = new ArrayList<>();
    }

    //Operaciones
    //Verificar si la cola está vacía o si tiene algo
    private boolean estaVacia() {
        return elementos.isEmpty();
    }

    //Insertar un nuevo ticket a la cola, especificamente por prioridad
    public void insertar(Ticket elemento) {

        int posicion = 0; //variable para capturar la posición en la que debe entrar

        while (posicion < elementos.size() && elementos.get(posicion).getPrioridad() >= elemento.getPrioridad()) { //agarramos la prioridad del objeto en x posicion y lo comparamos a ver si tiene más prioridad que el que quiere entrar
            posicion++; //Si sí tiene más prioridad que el nuevo entonces sumamos posición para analizar el siguiente en la cola
        }

        elementos.add(posicion, elemento); //cuando ya sepamos donde debe ir, le agregamos la posición dentro del array donde se tiene que añadir
    }

    //Metodo para resolver un ticket
    public Ticket resolver(){
        if (estaVacia()){ //verificamos si está vacía la cola
            System.out.println("\nLa cola está vacía");
            return null;
        }
        return elementos.removeFirst(); //eliminamos el primero en la cola y lo enviamos de vuelta y en el método principal es enviado a la lista enlazada
    }

    //Ver el primer elemento que hay en la cola
    public Ticket verFrente(){
        if (estaVacia()){
            System.out.println("\nLa cola está vacía");
            return null;
        }
        return elementos.getFirst(); //con este comando vemos el primero en cola
    }

    //Ver todos los tickets pendientes
    public void verTodos(){
        if (estaVacia()){
            System.out.println("\nLa cola está vacía");
            return;
        }

        for (Ticket ticket : elementos) { //ciclo que va imprimiento 1 por 1 de la lista de elementos.
            System.out.println(ticket);
            System.out.println("-------------------");
        }
    }
}
