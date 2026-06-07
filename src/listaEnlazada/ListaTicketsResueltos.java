package listaEnlazada;

public class ListaTicketsResueltos {

    //Atributo
    private Ticket primero;

    //Métodos
    //Constructor
    public ListaTicketsResueltos() {
        primero = null;
    }

    //Operaciones

    //Agregar a la lista una operación que evalúe si está vacía
    private boolean estaVacia(){
        return primero == null;
    }

    //Insertar nuevo nodo al inicio
    public void insertarInicio(Ticket ticket){
        ticket.setSiguiente(primero);
        primero = ticket;
    }

    //Buscar por id
    public Ticket buscar(int id){
        if(estaVacia()){
            System.out.println("\nNo hay tickets resueltos");
            return null;
        }

        Ticket temp = primero;
        while(temp != null){
            if(temp.getId() == id){
                System.out.println("\nTicket resuelto con la fecha" + temp.getFechaResolucion());
                return temp;
            }
            temp = temp.getSiguiente();
        }
        System.out.println("\nEl ticket buscado está pendiente");
        return null;
    }

    //Eliminar por id
    public Ticket eliminar(int id){
        if(estaVacia()){
            System.out.println("\nNo hay tickets por resueltos que eliminar");
            return null;
        }

        //Salvamos el primero de la lista para que no se pierda y lo guardamos en una variable auxiliar
        if (primero.getId() == id){
            Ticket aux = primero;
            primero = primero.getSiguiente();
            return aux;
        }

        Ticket temp = primero;
        Ticket anterior = temp;
        while(temp != null && temp.getId() != id){
            anterior = temp;
            temp = temp.getSiguiente();
        }
        if (temp == null){
            System.out.println("\nEl nombre buscado no está en la lista");
            return anterior;
        } else {
            anterior.setSiguiente(temp.getSiguiente());
            return temp;
        }


    }

    //Mostrar todo
    public void mostrarTodo(){
        if(estaVacia()){
            System.out.println("\nNo hay tickets por resueltos que eliminar");
            return;
        }

        Ticket temp = primero;

        while(temp != null){
            System.out.println(temp);
            System.out.println("-------------------");
            temp = temp.getSiguiente();
        }
    }
}
