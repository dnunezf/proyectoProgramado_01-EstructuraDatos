public class Arbol
{
    // VARIABLE GLOBAL QUE CORRESPONDE A LA RAIZ DEL ARBOL, PLANTAMOS EL ARBOL
    Nodo raiz;

    public Arbol()
    {
        raiz = null;
    }

    // METODO PARA INSERTAR LOS DATOS RESPECTIVOS AL ARBOL
    public void insertar(int i, Object fruta)
    {
        Nodo n = new Nodo(i);
        n.contenido = fruta;

        if (raiz == null)
        {
            raiz = n;
        }
        else
        {
            Nodo aux = raiz;

            while(aux != null)
            {
                n.padre = aux;

                if(n.indice >= aux.indice)
                {
                    aux = aux.derecha;
                }
                else
                {
                    aux = aux.izquierda;
                }
            }

            if (n.indice < n.padre.indice)
            {
                n.padre.izquierda = n;
            }
            else
            {
                n.padre.derecha = n;
            }
        }
    }

    // RECORRE DE FORMA RECURSIVA
    public void recorrer(Nodo n)
    {
        if (n != null)
        {
            recorrer(n.izquierda);
            System.out.println("INDICE: " + n.indice + " FRUTA " + n.contenido);
            recorrer(n.derecha);
        }
    }
}
