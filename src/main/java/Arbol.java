/*CLASE ÁRBOL*/

public class Arbol {
    // ATRIBUTO QUE CORRESPONDE A LA RAÍZ DEL ÁRBOL
    private Nodo raiz;

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
        raiz = new Nodo(new Animal("Ave"), reptil, aguila);
    }

    // MÉTODO PARA INSERTAR LOS ANIMALES AL ÁRBOL
    public void insertar() {
    }
}