import java.util.Iterator;

public class Contenedor<T extends Animal>{
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
    public void addLast(T elemento)
    {
        // Creamos un nuevo nodo, con el elemento y referencias nulas
        NodoD<T> newNodo = new NodoD<>(elemento, null, null);

        // Si la lista es vacia, el nuevo nodo será el único entre dummy y back
        if (dummy.getSiguiente() == back)
        {
            dummy.setSiguiente(newNodo);

            newNodo.setAnterior(dummy);
            newNodo.setSiguiente(back);

            back.setAnterior(newNodo);

            return;
        }

        // Encontramos el nodo anterior a back
        NodoD<T> lastNodo = back.getAnterior();

        // Actualizamos los punteros del nuevo nodo y ultimo nodo
        lastNodo.setSiguiente(newNodo);
        newNodo.setAnterior(lastNodo);
        newNodo.setSiguiente(back);
        back.setAnterior(newNodo);
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
    public void reverse()
    {
        // Si la lista es vacía o tiene solo un elemento, no se retorna nada
        if (dummy.getSiguiente() == back || dummy.getSiguiente().getSiguiente() == back) {
            return;
        }

        NodoD<T> current = dummy.getSiguiente();
        NodoD<T> temp = null;

        // Intercambiamos los punteros anterior y siguiente
        while (current != back)
        {
            temp = current.getAnterior();

            current.setAnterior(current.getSiguiente());
            current.setSiguiente(temp);

            current = current.getAnterior();
        }

        // Actualizamos dummy y back, después de invertir la lista
        temp = dummy.getSiguiente();

        dummy.setSiguiente(back.getAnterior());
        dummy.getSiguiente().setAnterior(dummy);
        back.setAnterior(temp);
        back.getAnterior().setSiguiente(back);
    }

    //MÉTODO QUE MUESTRA LOS ELEMENTOS DE LA LISTA
    public void display() {
        if (dummy.getSiguiente() == back) {
            System.out.println("La lista está vacía.");
            return;
        }
        NodoD<T> temp = dummy.getSiguiente();
        System.out.println();
        while (temp != back) {
            System.out.println(temp.getDato().toString());
            temp = temp.getSiguiente();
        }
    }

    // MÉTODO QUE VERIFICA SI LA LISTA ESTÁ VACÍA
    public boolean estaVacia() {
        return dummy.getSiguiente() == back;
    }
}
