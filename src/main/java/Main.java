/* MAIN

 * REFERENCIAS (BIBLIOGRAFÍAS):
 * (2019, 04 abril). JAVA - Recorrido de árboles binarios por niveles | Sergio Ramirez
 * https://youtu.be/RyKvFhoP200?si=1iKV8XVHpqXaKMhe
 * (2015, 26 enero). How does "\\d" work in java?
 * https://stackoverflow.com/questions/28145881/how-does-d-work-in-java/28145978#28145978

*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();
        System.out.println("\nÁrbol inicial:\n");
        arbol.imprimirNiveles();

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
    }
}