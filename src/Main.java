import colaDinamica.ColaPrioridad;
import listaEnlazada.ListaTicketsResueltos;
import listaEnlazada.Ticket;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); //Nos permite bajo la librería de Scanner leer el resultado de lo escrito por el usuario

        ColaPrioridad colaTickets = new ColaPrioridad(); //Generamos la cola de prioridad
        ListaTicketsResueltos listaResueltos = new ListaTicketsResueltos(); //Generamos la lista enlazada donde iran los tickets resueltos

        int opcionPrincipal; //variable que va a recibir el valor que el usuario nos ingrese

        //Primer menu el cuál hacemos con do while porque siempre va a ingresar al menos 1 vez
        do {
            System.out.println("\n===== SISTEMA DE TICKETS =====");
            System.out.println("1. Menú Usuario");
            System.out.println("2. Menú Administrador");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcionPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opcionPrincipal) {

                case 1:
                    menuUsuario(sc, colaTickets, listaResueltos);
                    break;

                case 2:
                    menuAdministrador(sc, colaTickets, listaResueltos);
                    break;

                case 0:
                    System.out.println("\nPrograma finalizado.");
                    break;

                default:
                    System.out.println("\nOpción inválida.");
            }

        } while (opcionPrincipal != 0);
    }

    /* Este método lo agregré para que el código no nos avance hasta que se presione enter, dado que me estresa que seponga el menu y ni siquiera pueda ver el resultado de lo que acabo de hacer */
    public static void pausar(Scanner sc) {
        System.out.println("\nPresione Enter para continuar...");
        sc.nextLine();
    }

    //Menu del usuario
    public static void menuUsuario(
            Scanner sc,
            ColaPrioridad colaTickets,
            ListaTicketsResueltos listaResueltos) {

        int opcion;

        do {
            System.out.println("\n===== MENÚ USUARIO =====");
            System.out.println("1. Crear ticket");
            System.out.println("2. Buscar ticket resuelto");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                //Caso para crear un ticket
                case 1:
                    System.out.print("Nombre completo: ");
                    String nombre = sc.nextLine();

                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine();

                    byte prioridad;

                    do { // creo este do while para verificar que el usuario solo ingrese datos entre 1 y 3.
                        System.out.print("Prioridad (1-Baja, 2-Media, 3-Alta): ");
                        prioridad = sc.nextByte();
                        sc.nextLine();

                        if (prioridad < 1 || prioridad > 3) {
                            System.out.println("Error. Debe ingresar 1, 2 o 3.");
                        }

                    } while (prioridad < 1 || prioridad > 3);

                    Ticket ticket = new Ticket( //con los datos recibidos creamos el nuevo ticket
                            nombre,
                            descripcion,
                            prioridad
                    );

                    colaTickets.insertar(ticket); //Agregamos a la cola de tickets por prioridad el nuevo ticket

                    System.out.println("\nTicket creado con ID: " + ticket.getId()); //confirmacion
                    System.out.println(ticket.toString()); //ticket creado
                    pausar(sc);
                    break;

                //Buscar ticket por ID
                case 2:
                    System.out.print(" \nIngrese ID del ticket: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    Ticket encontrado = listaResueltos.buscar(id);

                    if (encontrado != null) {
                        System.out.println(encontrado); //Si se encuentra, lo muestra
                    } else {
                        System.out.println("\nEl ticket está pendiente."); //Si no se encuentra, tira esto y en la fecha aun dice "pendiente"
                    }
                    pausar(sc);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("\nOpción inválida.");
            }

        } while (opcion != 0);
    }

    public static void menuAdministrador(
            Scanner sc,
            ColaPrioridad colaTickets,
            ListaTicketsResueltos listaResueltos) {

        int opcion;

        do {
            System.out.println("\n===== MENÚ ADMINISTRADOR =====");
            System.out.println("1. Ver ticket al frente");
            System.out.println("2. Resolver ticket");
            System.out.println("3. Ver todos los tickets");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                //Ver el ticket que está al inicio de la fila, lo más alto en la prioridad y el primero que debe resolverse
                case 1:

                    Ticket frente = colaTickets.verFrente();

                    if (frente == null) {
                        System.out.println("\nNo hay tickets pendientes.");
                    } else {
                        System.out.println(frente);
                    }
                    pausar(sc);
                    break;

                //Resolver el primer ticket que tenemos en prioridad
                case 2:

                    Ticket resuelto = colaTickets.resolver();

                    if (resuelto == null) {
                        System.out.println("\nNo hay tickets pendientes.");
                    } else {

                        resuelto.setFechaResolucion();

                        listaResueltos.insertarInicio(resuelto);

                        System.out.println(
                                "\nTicket resuelto con ID: " + resuelto.getId()
                                        + resuelto
                        );
                    }
                    pausar(sc);
                    break;

                //Ver todos los tickets que tenemos
                case 3:
                    colaTickets.verTodos();
                    pausar(sc);

                case 0:
                    break;

                default:
                    System.out.println("\nOpción inválida.");
            }

        } while (opcion != 0);
    }
}