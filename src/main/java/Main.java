/* MAIN

 * REFERENCIAS (BIBLIOGRAFÍAS):
 * (2019, 04 abril). JAVA - Recorrido de árboles binarios por niveles | Sergio Ramirez
 * https://youtu.be/RyKvFhoP200?si=1iKV8XVHpqXaKMhe
 * (2015, 26 enero). How does "\\d" work in java?
 * https://stackoverflow.com/questions/28145881/how-does-d-work-in-java/28145978#28145978
 * (2024, 17 setiembre). QuickSort on Doubly Linked List
 * https://www.geeksforgeeks.org/quicksort-for-linked-list/
 * (2024). JAVA program for Insertion in the End of a Doubly Linked List
 * https://prepinsta.com/java-program/for-insertion-at-the-end-in-doubly-linked-list/
 * (2023, 18 abril). Java Program For Reversing A Doubly Linked List
 * https://www.geeksforgeeks.org/java-program-for-reversing-a-doubly-linked-list/
 * (2023, 30 setiembre). Como Usar FILEWRITER Y FILEREADER con JAVA FÁCIL Y RÁPIDO| ACCESO A DATOS | DAM
 * https://youtu.be/hwHzl9POl40
 * (2022, 5 mayo). Try With Resources vs Try-Catch
 * https://stackoverflow.com/questions/26516020/try-with-resources-vs-try-catch
 * (2020, 10 julio). What is JSON - Convert Java Object To JSON using GSON - GSON tutorial
 * https://youtu.be/QGWSk5U0tgc

 */

import javax.swing.*;

public class Main {
    public static void main(String[] args)
    {
        // CARGA LAS IMÁGENES DE NUESTRO PROGRAMA
        ImageIcon icono = new ImageIcon("src/resources/animal.png");
        ImageIcon icono2 = new ImageIcon("src/resources/bye.png");

        // MENSAJE DE BIENVENIDA
        JOptionPane.showMessageDialog(null,
                "Bienvenido al programa Reino Animal",
                "Bienvenida", JOptionPane.INFORMATION_MESSAGE, icono);

        Arbol arbol = new Arbol();
        arbol.cargarArbol();
        Contenedor<Animal> animales = new Contenedor<>();
        HashMap hashMap = new HashMap(10);

        // Configuración inicial de la lista de animales.
        animales.addFirst(new Animal(5, "Gato"));
        animales.addFirst(new Animal(4, "Ballena"));
        animales.addFirst(new Animal(5, "Araña"));
        animales.addFirst(new Animal(5, "Perro"));
        animales.addFirst(new Animal(6, "Rana"));
        animales.addFirst(new Animal(1, "Águila"));
        animales.addFirst(new Animal(4, "Beta"));
        animales.addFirst(new Animal(2, "Lagarto"));
        animales.addFirst(new Animal(6, "Culebra"));

        // INSERTAMOS ANIMALES EN EL HASHMAP
        for (Animal animal : animales) {
            Contenedor<Animal> caracteristicas = new Contenedor<>();
            // Suponiendo que cada animal tiene una lista de características.
            caracteristicas.addFirst(animal); // Ahora estamos insertando el animal en el contenedor
            caracteristicas.addFirst(new Animal(0, "Color: Desconocido")); // Ejemplo de características
            caracteristicas.addFirst(new Animal(0, "Hábitat: Desconocido")); // Otro ejemplo
            hashMap.insertar(animal.getNombre(), caracteristicas); // Insertar en el HashMap
        }

        boolean continuar = true;

        // MENÚ DE OPCIONES DEL SISTEMA
        while (continuar) {
            String opcion = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:\n" +
                            "1: Imprimir el árbol\n" +
                            "2: Jugar\n" +
                            "3: Guardar el árbol\n" +
                            "4: Proyectar las listas\n" +
                            "5: Buscar características de un animal\n" +
                            "0: Salir",
                    "Menú de Opciones",
                    JOptionPane.QUESTION_MESSAGE);

            if (opcion == null || opcion.equals("")) {
                continuar = false;
                break;
            }

            switch (opcion) {
                case "1":
                    System.out.println("\nÁrbol completo:");
                    arbol.imprimirNiveles();
                    break;

                case "2":
                    jugar(arbol);
                    break;

                case "3":
                    guardarArbol(arbol);
                    break;

                case "4":
                    proyectarListas(animales);
                    break;

                case "5":
                    String nombreAnimal = JOptionPane.showInputDialog(null, "Ingrese el nombre del animal:", "Buscar características", JOptionPane.QUESTION_MESSAGE);

                    if (nombreAnimal != null && !nombreAnimal.equals("")) {
                        hashMap.features(nombreAnimal); // Llamar al método features del HashMap
                    }
                    break;

                case "0":
                    continuar = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente nuevamente.", "Error", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }

        // MENSAJE DE DESPEDIDA
        JOptionPane.showMessageDialog(null,
                "Gracias por usar el programa Reino Animal. ¡Hasta la próxima!",
                "Despedida", JOptionPane.INFORMATION_MESSAGE, icono2);
    }

    // MÉTODO QUE PERMITE AL USUARIO JUGAR
    public static void jugar(Arbol arbol)
    {
        boolean jugar = true;

        while (jugar)
        {
            try {
                arbol.insertar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            String respuestaUser = JOptionPane.showInputDialog(null, "Desea volver a jugar:\n1:Si 0:No", "Jugar", JOptionPane.QUESTION_MESSAGE);

            if (respuestaUser == null || respuestaUser.equals("")) {
                jugar = false;
                break;
            }

            int respuesta = Integer.parseInt(respuestaUser);

            if (respuesta == 0) {
                jugar = false;
            }
        }
    }

    // MÉTODO QUE PERMITE GUARDAR O NO EL ÁRBOL, LUEGO DE JUGAR
    public static void guardarArbol(Arbol arbol) {
        try
        {
            String guardarUser = JOptionPane.showInputDialog(null, "Desea guardar el árbol:\n1:Si 0:No", "Guardar", JOptionPane.QUESTION_MESSAGE);

            if (guardarUser == null || guardarUser.equals("")) {
                return;
            }

            int guardar = Integer.parseInt(guardarUser);

            if (guardar == 1) {
                arbol.guardarArbol();
                JOptionPane.showMessageDialog(null, "Árbol guardado con éxito.", "Guardar", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Proyeccion de listas
    public static void proyectarListas(Contenedor<Animal> animales)
    {
        System.out.println("\nProyección de la Lista de Animales:");
        animales.display();

        System.out.println("\nPrueba de ordenamiento:");
        animales.sort();
        animales.display();

        System.out.println("\nAñadir un nuevo animal al final:");
        animales.addLast(new Animal(3, "Elefante"));
        animales.display();

        System.out.println("\nPrueba de invertir la lista:");
        animales.reverse();
        animales.display();
    }
}