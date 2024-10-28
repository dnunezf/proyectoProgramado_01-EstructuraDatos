public class HashMap
{
    private Contenedor<Animal>[] animales;

    // INICIALIZAREMOS EL ARRAY CON UNA CAPACIDAD DADA
    public HashMap(Integer capacidad) {
        animales = new Contenedor[capacidad];
        for (int i = 0; i < capacidad; i++) {
            animales[i] = null;
        }
    }

    // IMPLEMENTAMOS LA FUNCION DE DISPERSION
    public Integer funcionDispersion(String nombre) {
        int hash = 0;

        for (int i = 0; i < nombre.length(); i++) {
            hash = (hash * 31) + nombre.charAt(i);
        }

        return Math.abs(hash) % animales.length;
    }

    // MÉTODO QUE INSERTA UN ANIMAL AL MAP, EVITANDO COLISIONES
    public void insertar(String nombre, Contenedor<Animal> caracteristicas) {
        int index = funcionDispersion(nombre);

        while (animales[index] != null && !animales[index].equals(caracteristicas)) {
            index = (index + 1) % animales.length; // Linear probing para colisiones
        }

        animales[index] = caracteristicas;
    }

    // MÉTODO FEATURES, BUSCA LAS CARACTERÍSTICAS DE UN ANIMAL EN EL MAP
    public void features(String nombre) {
        int index = funcionDispersion(nombre);
        int startIndex = index; // DETECTAMOS EL CICLO COMPLETO, EN CASO DE COLISIÓN

        while (animales[index] != null)

        {
            if (animales[index].equals(nombre)) {
                System.out.print("Características de " + nombre + ": ");
                animales[index].display();
                return;
            }
            index = (index + 1) % animales.length;
            if (index == startIndex) break; // EVITAR QUE SE ENCICLE
        }
        System.out.println("No existe");
    }
}