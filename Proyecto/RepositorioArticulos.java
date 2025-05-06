package Proyecto;

import java.util.ArrayList;
import java.util.List;

public class RepositorioArticulos {
    private static List<Articulo> articulosGlobales = new ArrayList<>();

    public static void registrarArticulo(Articulo articulo) {
        articulosGlobales.add(articulo);
    }

    public static List<Articulo> getAllArticulos() {
        return articulosGlobales;
    }
}
