/*CLASE NODO*/

public class Nodo {
    // Atributos de la clase Nodo
    private Animal animal;
    private Nodo hijoIzquierdo;
    private Nodo hijoDerecho;

    // Constructores

    public Nodo(Animal animal) {
        this(animal, null, null);
    }

    public Nodo(Animal animal, Nodo hijoIzquierdo, Nodo hijoDerecho) {
        this.animal = animal;
        this.hijoIzquierdo = hijoIzquierdo;
        this.hijoDerecho = hijoDerecho;
    }

    // GETTER'S AND SETTER'S

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Nodo getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(Nodo hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public Nodo getHijoDerecho() {
        return hijoDerecho;
    }

    public void setHijoDerecho(Nodo hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }
}