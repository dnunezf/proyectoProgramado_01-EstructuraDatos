public class Main
{
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.insertar(4, "Naranja");
        arbol.insertar(8, "Manzana");
        arbol.insertar(1, "Uva");
        arbol.insertar(9, "Sandia");
        arbol.insertar(7, "Pera");

        // NODO CON EL CUAL INICIALIZAMOS EL METODO, Y A PARTIR DE AHI RECORREMOS
        arbol.recorrer(arbol.raiz);
    }
}
