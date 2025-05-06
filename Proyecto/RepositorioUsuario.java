package Proyecto;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuario {
    private static List<Registrado> listaUsuariosRegistrados = new ArrayList<>();

    public static void registrarUsuario (Registrado registrado) {
        listaUsuariosRegistrados.add(registrado);
    }

    public static List<Registrado> getAllUsuarios() {
        return new ArrayList<>(listaUsuariosRegistrados);
    }
}
