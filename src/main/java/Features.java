/*CLASE FEATURES*/

import java.util.HashMap;
import java.util.Map;

public class Features {

    private Map<String, String> caracteristicas;

    public Features() {
        caracteristicas = new HashMap<>();
    }

    // PERMITE AGREGAR UN ANIMAL CON SUS CARACTERÍSTICAS
    public void addAnimal(String nombre, String caracteristicas) {
        this.caracteristicas.put(nombre, caracteristicas);
    }

    // BUSCAR LAS CARACTERÍSTICAS DE UN ANIMAL
    public String features(String animal) {
        // containsKey(llave) verifica si la llave existe en el mapa
        if (!caracteristicas.containsKey(animal)) {
            return "No existe";
        } else {
            String caracteristicasString = caracteristicas.get(animal);
            return "Características de " + animal + ": " + caracteristicasString;
        }
    }
}
