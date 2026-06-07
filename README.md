# Sistema de Gestión de Tickets con Cola de Prioridad

Este proyecto es una aplicación en Java que simula un sistema de gestión de tickets (tipo mesa de ayuda o soporte técnico), utilizando estructuras de datos personalizadas como colas de prioridad y listas enlazadas.

---

## Funcionalidades

El sistema está dividido en dos módulos principales:

### Modo Usuario

- Crear un ticket con:
  - Nombre del usuario
  - Descripción del problema
  - Nivel de prioridad (1 = Baja, 2 = Media, 3 = Alta)
- Buscar un ticket resuelto por ID
- Validación de datos de entrada

---

### Modo Administrador

- Ver el ticket con mayor prioridad (frente de la cola)
- Resolver el primer ticket en cola
- Ver todos los tickets pendientes

---

## Estructuras de Datos Utilizadas

### Cola de Prioridad (ColaPrioridad)

- Organiza los tickets según su nivel de prioridad (3 (alta) > 2 > 1 (baja))
- Permite insertar, ver frente, resolver y listar tickets

### Lista Enlazada (ListaTicketsResueltos)

- Almacena los tickets ya resueltos
- Permite búsqueda por ID

### Objeto Ticket (Ticket)

- Representa cada solicitud
- Contiene:
  - ID único
  - Nombre del usuario
  - Descripción
  - Prioridad
  - Fecha de creación y resolución

---

## Estructura del Menú

### SISTEMA DE TICKETS

1. Menú Usuario  
2. Menú Administrador  
0. Salir  

---

### Menú Usuario

1. Crear ticket  
2. Buscar ticket resuelto  
0. Volver  

---

### Menú Administrador

1. Ver ticket al frente  
2. Resolver ticket  
3. Ver todos los tickets  
0. Volver  

