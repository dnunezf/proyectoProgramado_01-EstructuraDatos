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
 *
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        System.out.println("\nÁrbol inicial:\n");
        arbol.imprimirNiveles();
        System.out.println();

        //PRUEBA DEL INSERTAR
        boolean jugar = true;
        while (jugar) {
            try {
                arbol.insertar();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            int respuesta;
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Desea volver a jugar: " + "\n1:Si 0:No");
            try {
                respuesta = Integer.parseInt(br.readLine());
                if (respuesta == 0) {
                    jugar = false;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Árbol con los cambios:\n");
            arbol.imprimirNiveles();
        }

        System.out.println("\nPrueba Lista Doblemente Enlazada");
        Contenedor<Animal> animales = new Contenedor<>();
        animales.addFirst(new Animal(5, "Gato"));
        animales.addFirst(new Animal(4, "Ballena"));
        animales.addFirst(new Animal(5, "Araña"));
        animales.addFirst(new Animal(5, "Perro"));
        animales.addFirst(new Animal(6, "Rana"));
        animales.addFirst(new Animal(1, "Águila"));
        animales.addFirst(new Animal(4, "Beta"));
        animales.addFirst(new Animal(2, "Lagarto"));
        animales.addFirst(new Animal(6, "Culebra"));

        animales.display();
        System.out.println("\nPrueba de ordenamiento\n");
        animales.sort();
        animales.display();
    }
}