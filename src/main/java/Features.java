import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Features {

    private Map<String, List<String>> caracteristicas;

    public Features() {
        caracteristicas = new HashMap<>();
    }

    // PERMITE AGREGAR UN ANIMAL CON SUS CARACTERÍSTICAS
    public void addAnimal(String nombre, List<String> characteristics) {
        caracteristicas.put(nombre, characteristics);
    }

    // BUSCAR LAS CARACTERÍSTICAS DE UN ANIMAL
    public String features(String animal)
    {
        // containsKey(llave) verifica si la llave existe en el mapa
        if (!caracteristicas.containsKey(animal))
        {
            return "No existe";
        }
        else
        {
            List<String> caracteristicasList = caracteristicas.get(animal);

            return "Características de " + animal + ": " + caracteristicas.toString();
        }
    }
}
