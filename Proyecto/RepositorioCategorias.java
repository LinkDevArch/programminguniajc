package Proyecto;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCategorias {
    private static List<Categoria> categorias = new ArrayList<>();

    public static Categoria getCategoriaPorNombre(String nombre) {
        for (Categoria categoria : categorias) {
            if (categoria.getNombre().equalsIgnoreCase(nombre)) {
                return categoria;
            }
        }
        return null;
    }

    public static void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public static List<Categoria> getAllCategorias() {
        return categorias;
    }
}
