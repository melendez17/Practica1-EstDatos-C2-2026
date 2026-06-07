package listaEnlazada;

import java.time.LocalDateTime;

public class Ticket { //clase que va a representar un ticket dentro de nuestro sistema

    private static int contador = 1; //Este contador nos va a ayudar a generar IDs unicos e incrementales

    //Atributos
    private int id;
    private String nombreUsuario;
    private String descripcion;
    private byte prioridad;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaResolucion;
    private Ticket siguiente; //Este es el que nos referencia al SIGUIENTE nodo de la lista enlazada

    //Metodos

    //Constructor
    public Ticket(String nombreUsuario, String descripcion, byte prioridad) {
        this.id = contador++; //hacemos el id autoincremental
        this.nombreUsuario = nombreUsuario;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.fechaCreacion = LocalDateTime.now(); //agarramos la fecha actual
        this.fechaResolucion = null; //ponemos null porque el ticket va a tener fecha de resolución hasta que usemos el método de resolver y capturemos la fecha de ese momento
        this.siguiente = null; //Es null hasta que le definamos a quien va a apuntar
    }

    //Getter
    public int getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public byte getPrioridad() {
        return prioridad;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getFechaResolucion() {
        return fechaResolucion;
    }

    public Ticket getSiguiente() {
        return siguiente;
    }

    //Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrioridad(byte prioridad) {
        this.prioridad = prioridad;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaResolucion() {
        this.fechaResolucion = LocalDateTime.now();
    }

    public void setSiguiente(Ticket siguiente) {
        this.siguiente = siguiente;
    }

    //ToString()
    @Override
    public String toString() {
        String textoPrioridad;

        switch (prioridad) {
            case 1:
                textoPrioridad = "Baja";
                break;
            case 2:
                textoPrioridad = "Media";
                break;
            case 3:
                textoPrioridad = "Alta";
                break;
            default:
                textoPrioridad = "Desconocida";
        }

        return "\n===== TICKET =====" +
                "\nID: " + id +
                "\nUsuario: " + nombreUsuario +
                "\nDescripción: " + descripcion +
                "\nPrioridad: " + textoPrioridad +
                "\nFecha de creación: " + fechaCreacion +
                "\nFecha de resolución: " +
                (fechaResolucion == null ? "Pendiente" : fechaResolucion) +
                "\n==================";
    }
}
