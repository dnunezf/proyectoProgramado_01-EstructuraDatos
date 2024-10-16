/*CLASE ANIMAL*/

import java.util.Objects;

public class Animal {
    // Atributos de la clase Animal
    private String nombre;
    private Integer codigo;

    // Constructor
    public Animal(String nombre)
    {
        this.nombre = nombre;
        this.codigo = 0; // Inicializado en 0
    }

    // GETTER'S AND SETTER'S

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
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
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(nombre, animal.nombre) && Objects.equals(codigo, animal.codigo);
    }

    // Método hashCode, cambiaremos en parte II...
    @Override
    public int hashCode() {
        return Objects.hash(nombre, codigo);
    }
}
