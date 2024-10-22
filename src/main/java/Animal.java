/*CLASE ANIMAL*/

import java.util.Objects;

public class Animal {
    // Atributos de la clase Animal
    private Integer codigo;
    private String nombre;

    // Constructor
    public Animal(String nombre) {
        this.codigo = 0; // Inicializado en 0
        this.nombre = nombre;
    }

    // GETTER'S AND SETTER'S

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método toString
    @Override
    public String toString() {
        return "Animal{" +
                "nombre='" + nombre + '\'' +
                ", codigo=" + codigo +
                '}';
    }

    // Método equals, compara dos objetos Animal
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(nombre, animal.nombre) && Objects.equals(codigo, animal.codigo);
    }

    // Método hashCode, genera un código hash basado en el código del objeto Animal
    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}