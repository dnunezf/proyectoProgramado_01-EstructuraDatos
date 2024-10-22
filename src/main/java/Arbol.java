/*CLASE ÁRBOL*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Arbol {
    // ATRIBUTO QUE CORRESPONDE A LA RAÍZ DEL ÁRBOL
    private Nodo nodoRaiz;

    // ATRIBUTO QUE ALMACENA LA ALTURA ACTUAL DEL ÁRBOL
    private int alturaArbol;

    // ARREGLO QUE CONTIENE LAS REPRESENTACIONES DE LOS NIVELES DEL ÁRBOL
    private String[] nivelesArbol;

    // Constructor
    public Arbol() {
        // Creación de los animales
        Nodo culebra = new Nodo(new Animal("Culebra"));
        Nodo rana = new Nodo(new Animal("Rana"));
        Nodo arana = new Nodo(new Animal("Araña"));
        Nodo beta = new Nodo(new Animal("Beta"));
        Nodo perro = new Nodo(new Animal("Perro"));
        Nodo gato = new Nodo(new Animal("Gato"));
        Nodo ballena = new Nodo(new Animal("Ballena"));
        Nodo lagarto = new Nodo(new Animal("Lagarto"));
        Nodo aguila = new Nodo(new Animal("Águila"));

        // Creación de las características
        Nodo anfibio = new Nodo(new Animal("Anfibio"), culebra, rana);
        Nodo invertebrado = new Nodo(new Animal("Invertebrado"), anfibio, arana);
        Nodo pez = new Nodo(new Animal("Pez"), invertebrado, beta);
        Nodo maulla = new Nodo(new Animal("Maulla"), perro, gato);
        Nodo acuatico = new Nodo(new Animal("Acuático"), maulla, ballena);
        Nodo mamifero = new Nodo(new Animal("Mamífero"), pez, acuatico);
        Nodo reptil = new Nodo(new Animal("Reptil"), mamifero, lagarto);

        // Asignar la raíz
        nodoRaiz = new Nodo(new Animal("Ave"), reptil, aguila);
    }

    // MÉTODOS PARA INSERTAR ANIMALES AL ÁRBOL
    public void insertar() throws Exception {
        //Siempre se empieza el proceso desde la raíz
        insertarRecursivo(nodoRaiz);
    }

    //Es un método privado, ya que solo se puede usar dentro de la clase en la que está definido
    private void insertarRecursivo(Nodo padre) throws Exception {
        //Variables utilizadas para recibir la respuesta del usuario
        int respuesta;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //Se le pide al usuario que inserte una respuesta
        System.out.println("Su animal tiene la siguiente característica o es el siguiente: " + padre.getAnimal().getNombre() + "\n1:Si 0:No");
        try {
            //Se lee la respuesta del usuario y se almacena como un número entero mediante el método Integer.parseInt
            respuesta = Integer.parseInt(br.readLine());

            //Control que verifica si la respuesta es diferente de 0 o 1
            if (respuesta < 0 || respuesta > 1) {
                throw new Exception("Respuesta inválida");
            }

            //Variables utilizadas para hacer el cambio de orden en los nodos cuando se inserta un animal
            String nombreTemporal;
            String caracteristica;
            String nombre;

            if (respuesta == 0) {
                if (padre.getHijoIzquierdo() == null && padre.getHijoDerecho() == null) {
                    //Se le preguntan los datos del animal para agregar los nuevos nodos al árbol
                    System.out.println("Entonces, dígame el nombre del animal que está pensando:");
                    nombre = br.readLine();
                    //Se vertifica que no hayan números dentro del nombre del animal
                    if(contieneNumeros(nombre)){
                        throw new Exception("El nombre no puede contener números");
                    }

                    System.out.println("Ahora, dígame una característica única del animal que está pensando:");
                    caracteristica = br.readLine();
                    //Se vertifica que no hayan números dentro de la característica del animal
                    if(contieneNumeros(caracteristica)){
                        throw new Exception("La característica no puede contener números");
                    }

                    //Se realiza el cambio de orden y se insertan los nuevos nodos
                    nombreTemporal = padre.getAnimal().getNombre();
                    padre.setAnimal(new Animal(caracteristica));
                    padre.setHijoIzquierdo(new Nodo(new Animal(nombreTemporal)));
                    padre.setHijoDerecho(new Nodo(new Animal(nombre)));
                } else {
                    //Si no es una hoja se llama al método recursivamente para que siga con el nodo hijo izquierdo
                    insertarRecursivo(padre.getHijoIzquierdo());
                }
            } else {
                if (padre.getHijoDerecho() == null && padre.getHijoIzquierdo() == null) {
                    //Si es una hoja y la respuesta es afirmativa, entonces significa que ya se adivinó el animal
                    System.out.println("¡Adiviné! El animal en el que estaba pensando es un/una " + padre.getAnimal().getNombre());
                } else {
                    //Si no es una hoja se llama al método recursivamente para que siga con el nodo hijo derecho
                    insertarRecursivo(padre.getHijoDerecho());
                }
            }
            //Control que verifica si la respuesta es o no un número
        } catch (NumberFormatException e) {
            System.out.println("Respuesta inválida");
        }
    }

    // MÉTODO PARA VERIFICAR SI UN STRING CONTIENE ALGÚN NÚMERO
    private boolean contieneNumeros(String entrada) {
        return entrada.matches(".*\\d.*");
    }

    // MÉTODO PARA CALCULAR Y OBTENER LA ALTURA DEL ÁRBOL
    public int calcularAltura() {
        alturaArbol = 0;
        calcularAlturaRecursiva(nodoRaiz, 0);
        return alturaArbol;
    }

    // MÉTODO RECURSIVO PRIVADO PARA CALCULAR LA ALTURA DEL ÁRBOL
    // MÉTODO AUXILIAR
    private void calcularAlturaRecursiva(Nodo nodoActual, int nivelActual) {
        if (nodoActual != null) {
            calcularAlturaRecursiva(nodoActual.getHijoIzquierdo(), nivelActual + 1);

            if (nivelActual > alturaArbol) {
                alturaArbol = nivelActual;
            }

            calcularAlturaRecursiva(nodoActual.getHijoDerecho(), nivelActual + 1);
        }
    }

    // MÉTODO PARA IMPRIMIR LOS NIVELES DEL ÁRBOL
    public void imprimirNiveles() {
        // Primero, calculamos la altura del árbol
        alturaArbol = calcularAltura();

        // Inicializa el arreglo de niveles
        nivelesArbol = new String[alturaArbol + 1];

        // Inicializa cada nivel como una cadena vacía
        for (int i = 0; i < nivelesArbol.length; i++) {
            nivelesArbol[i] = "";
        }

        // Llama al método recursivo, para llenar los niveles
        llenarNivelesRecursivamente(nodoRaiz, 0);

        // Imprime los niveles
        for (int i = 0; i < nivelesArbol.length; i++) {
            System.out.println("Nivel " + i + ": " + nivelesArbol[i]);
        }
    }

    // MÉTODO RECURSIVO PRIVADO PARA LLENAR EL ARREGLO DE NIVELES DEL ÁRBOl
    // MÉTODO AUXILIAR
    private void llenarNivelesRecursivamente(Nodo nodoActual, int nivelActual) {
        if (nodoActual != null) {
            // Agrega el nombre del animal al nivel actual
            nivelesArbol[nivelActual] += nodoActual.getAnimal().getNombre() + " ";

            // Continuar con los nodos hijos
            llenarNivelesRecursivamente(nodoActual.getHijoIzquierdo(), nivelActual + 1);
            llenarNivelesRecursivamente(nodoActual.getHijoDerecho(), nivelActual + 1);
        }
    }
}