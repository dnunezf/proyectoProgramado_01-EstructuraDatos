public class Contenedor<T> {
    private NodoD<T> dummy;
    private NodoD<T> back;

    // Constructor
    public Contenedor() {
        dummy = new NodoD<>();
        back = new NodoD<>();
        dummy.setSiguiente(back);
        back.setAnterior(dummy);
    }

    //MÉTODO PARA AÑADIR EN LA PRIMERA POSICIÓN DE LA LISTA
    public void addFirst(T elemento) {
        // Se obtiene el primer nodo antes de insertar el nuevo
        NodoD<T> primerNodo = dummy.getSiguiente();

        // Se crea un nodo con el dato y se le asocia dummy como nodo anterior,
        // y el que antes estaba de primero, como el nodo siguiente
        NodoD<T> nuevoNodo = new NodoD<>(elemento, dummy, primerNodo);

        // Se actualizan los datos de los nodos existentes de la lista
        dummy.setSiguiente(nuevoNodo);
        primerNodo.setAnterior(nuevoNodo);
    }

    //MÉTODO PARA AÑADIR EN LA ÚLTIMA POSICIÓN DE LA LISTA
    public void addLast(T elemento) {
    }

    //MÉTODO QUE ORDENA LOS ANIMALES DE MENOR A MAYOR SEGÚN EL CÓDIGO
    public void sort() {
    }

    //MÉTODO QUE INVIERTE TODOS LOS ELEMENTOS
    public void reverse() {
    }

    //MÉTODO QUE MUESTRA LOS ELEMENTOS DE LA LISTA
    public void display() {
        if (dummy.getSiguiente() == back) {
            System.out.println("La lista está vacía.");
            return;
        }
        NodoD<T> temp = dummy.getSiguiente();
        while (temp != back) {
            System.out.println(temp.getDato().toString());
            temp = temp.getSiguiente();
        }
    }
}
