public class Contenedor<T extends Animal> {
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

    //MÉTODOS UTILIZADOS PARA ORDENAR LOS ANIMALES DE MENOR A MAYOR SEGÚN EL CÓDIGO
    private void intercambiar(NodoD<T> a, NodoD<T> b) {
        // Intercambia los datos del nodo a con el b
        T temp = a.getDato();
        a.setDato(b.getDato());
        b.setDato(temp);
    }

    private NodoD<T> particion(NodoD<T> izquierdo, NodoD<T> derecho) {
        // Establece el pivote como el dato del nodo derecho
        T pivote = derecho.getDato();

        // Puntero para colocar los elementos menores
        NodoD<T> i = izquierdo.getAnterior();

        // Recorre la lista desde el nodo "izquierdo" hasta el nodo "derecho"
        for (NodoD<T> j = izquierdo; j != derecho; j = j.getSiguiente()) {

            // Si el código del dato actual es menor o igual que el del pivote
            if (j.getDato().getCodigo() <= pivote.getCodigo()) {
                // Mueve `i` hacia adelante y realiza el intercambio con `j`
                i = (i == null) ? izquierdo : i.getSiguiente();
                intercambiar(i, j);
            }
        }

        // Mueve `i` a la posición correcta del pivote
        i = (i == null) ? izquierdo : i.getSiguiente();

        // Intercambia el dato del pivote con el dato de `i`
        intercambiar(i, derecho);

        // Retorna la posición del pivote
        return i;
    }

    private void quicksort(NodoD<T> izquierdo, NodoD<T> derecho) {
        // Caso base: detiene la recursión cuando el rango es inválido
        if (izquierdo != null && derecho != null && izquierdo != derecho && izquierdo != derecho.getSiguiente()) {
            // Realiza la partición de la lista y obtiene el nodo pivote
            NodoD<T> pivot = particion(izquierdo, derecho);

            // Ordena recursivamente la mitad izquierda
            quicksort(izquierdo, pivot.getAnterior());

            // Ordena recursivamente la mitad derecha
            quicksort(pivot.getSiguiente(), derecho);
        }
    }

    public void sort() {
        quicksort(dummy.getSiguiente(), back.getAnterior());
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
