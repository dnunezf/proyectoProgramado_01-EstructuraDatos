public class Nodo
{
    public Nodo padre;
    public Nodo derecha;
    public Nodo izquierda;
    public int indice; // NUMERO QUE IDENTIFICA AL NODO
    public Object contenido; // A FUTURO CAMBIAR POR EL OBJETO ANIMAL DE NUESTRO PROYECTO

    public Nodo(int indice)
    {
        this.indice = indice;
        derecha = null;
        izquierda = null;
        padre = null;
        contenido = null;
    }
}
