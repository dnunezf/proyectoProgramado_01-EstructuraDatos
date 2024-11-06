/* MAIN

    / -------------------------------------------------------------------+
    * |
    * (c) 2024 |
    * 4-0268-0547 - Joseph García Montero      |
    * 1-1908-0008 - David Alberto Núñez Franco |
    * version 1.0.0 2024-11-12 |
    * |
    * -------------------------------------------------------------------+

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
     * (2021, 14 junio). Map and HashMap in Java - Full Tutorial. https://youtu.be/H62Jfv1DJlU?si=xj2pa0fgjDzkYXio

 */

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
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
        Features features = new Features();  // Instancia de la clase Features, contiene el HashMap

        boolean continuar = true;

        // MENÚ DE OPCIONES DEL SISTEMA
        while (continuar) {
            String opcion = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:\n" +
                            "1: Imprimir el árbol\n" +
                            "2: Jugar\n" +
                            "3: Guardar el árbol\n" +
                            "4: Llenar la lista con los animales\n" +
                            "5: Ordenar la lista\n" +
                            "6: Invertir la lista\n" +
                            "7: Mostrar la lista\n" +
                            "8: Buscar características de un animal\n" +
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
                    arbol.llenarLista(animales);
                    JOptionPane.showMessageDialog(null, "Se llenó la lista con éxito.", "Llenar la lista", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "5":
                    animales.sort();
                    if (animales.estaVacia())
                        JOptionPane.showMessageDialog(null, "Lista vacía.", "Ordenar la lista", JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "Lista ordenada con éxito.", "Ordenar la lista", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "6":
                    animales.reverse();
                    if (animales.estaVacia())
                        JOptionPane.showMessageDialog(null, "Lista vacía.", "Invertir la lista", JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "Lista invertida con éxito.", "Invertir la lista", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case "7":
                    if (animales.estaVacia())
                        JOptionPane.showMessageDialog(null, "Lista vacía.", "Mostrar la lista", JOptionPane.ERROR_MESSAGE);
                    else
                        animales.display();
                    break;
                case "8":
                    arbol.llenarMapaConCaracteristicas(features);
                    String animal = JOptionPane.showInputDialog("Ingrese el nombre del animal para buscar sus características:");

                    if (animal != null && !animal.isEmpty()) {
                        JOptionPane.showMessageDialog(null, features.features(animal), "Características", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "Entrada no válida.", "Error", JOptionPane.ERROR_MESSAGE);
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
    public static void jugar(Arbol arbol) {
        boolean jugar = true;

        while (jugar) {
            try {
                arbol.insertar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }

            boolean entradaValida = false;

            while (!entradaValida) {
                String respuestaUser = JOptionPane.showInputDialog(null, "Desea volver a jugar:\n1:Si 0:No", "Jugar", JOptionPane.QUESTION_MESSAGE);

                if (respuestaUser == null || respuestaUser.equals("")) {
                    jugar = false;
                    entradaValida = true;
                    break;
                }

                try {
                    int respuesta = Integer.parseInt(respuestaUser);

                    if (respuesta == 0) {
                        jugar = false;
                    } else if (respuesta == 1) {
                        jugar = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese 1 para Sí o 0 para No.", "Entrada inválida", JOptionPane.WARNING_MESSAGE);
                        continue;
                    }

                    entradaValida = true;

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor ingrese 1 para Sí o 0 para No.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    // MÉTODO QUE PERMITE GUARDAR O NO EL ÁRBOL, LUEGO DE JUGAR
    public static void guardarArbol(Arbol arbol) {
        try {
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
}