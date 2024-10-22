public class NodoD<T> {
    private T dato;
    private NodoD<T> anterior;
    private NodoD<T> siguiente;

    // Constructores

    public NodoD() {
        this(null, null, null);
    }

    public NodoD(T dato, NodoD<T> anterior, NodoD<T> siguiente) {
        this.dato = dato;
        this.anterior = anterior;
        this.siguiente = siguiente;
    }

    // GETTER'S AND SETTER'S

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoD<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoD<T> anterior) {
        this.anterior = anterior;
    }

    public NodoD<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoD<T> siguiente) {
        this.siguiente = siguiente;
    }
}
