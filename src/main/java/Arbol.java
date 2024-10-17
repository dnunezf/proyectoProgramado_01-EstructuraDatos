/*CLASE ÁRBOL*/

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

    // MÉTODO PARA INSERTAR LOS ANIMALES AL ÁRBOL
    public void insertar() {
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
    public void imprimirNiveles()
    {
        // Primero, calculamos la altura del árbol
        alturaArbol = calcularAltura();

        // Inicializa el arreglo de niveles
        nivelesArbol = new String[alturaArbol + 1];

        // Inicializa cada nivel como una cadena vacía
        for (int i = 0; i < nivelesArbol.length; i++)
        {
            nivelesArbol[i] = "";
        }

        // Llama al método recursivo, para llenar los niveles
        llenarNivelesRecursivamente(nodoRaiz, 0);

        // Imprime los niveles
        for (int i = 0; i < nivelesArbol.length; i++) {
            System.out.println("Nivel " + i + ": " + nivelesArbol[i]);
        }
    }

    // MÉTODO RECURSIVO PRIVADO PARA LLENAR EL ARREGLO DE NIVELES DEL ÁRBO
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