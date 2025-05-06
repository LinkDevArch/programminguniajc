package Proyecto;

import java.util.ArrayList;
import java.util.List;

public class Categoria {

    private String nombre;
    private List<Articulo> articulosConLaCategoria;

    public Categoria(String nombre) {
        this.nombre = nombre;
        this.articulosConLaCategoria = new ArrayList<>();
    }

    // Agregar un artículo a la categoría
    public void agregarArticulo(Articulo articulo) {
        if (!articulosConLaCategoria.contains(articulo)) {
            articulosConLaCategoria.add(articulo);
            articulo.setCategoria(this); // Relación bidireccional
        }
    }

    // Eliminar un artículo de la categoría
    public void eliminarArticulo(Articulo articulo) {
        if (articulosConLaCategoria.contains(articulo)) {
            articulosConLaCategoria.remove(articulo);
            articulo.setCategoria(null); // Romper la relación bidireccional
        }
    }

    // Obtener el nombre de la categoría
    public String getNombre() {
        return nombre;
    }

    // Cambiar el nombre de la categoría
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Obtener la lista de artículos asociados a la categoría
    public List<Articulo> getArticulosConLaCategoria() {
        return articulosConLaCategoria;
    }
}
