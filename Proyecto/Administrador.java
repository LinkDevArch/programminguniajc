package Proyecto;

import java.util.Date;

public class Administrador extends Usuario {
    
    private String nombreCompleto;
    private final String rol = "admin";

    public Administrador(int id, String email, String password, String nombreCompleto) {
        super(id, email, password);
        this.nombreCompleto = nombreCompleto;
    }

    public Articulo crearArticulo(String titulo, String nombreCategoria , String contenido, String imagen, Date fecha) {
        
        // Verificar si la categoría ya existe
        Categoria categoria = RepositorioCategorias.getCategoriaPorNombre(nombreCategoria);
        if (categoria == null) {
            // Crear una nueva categoría si no existe
            categoria = new Categoria(nombreCategoria);
            RepositorioCategorias.agregarCategoria(categoria);
        }
        
        Articulo a = new Articulo(this, categoria,titulo, contenido, imagen, fecha);
        addArticulo(a);
        categoria.agregarArticulo(a); //Agrega el articulo a la categoria
        RepositorioArticulos.registrarArticulo(a);

        return a;
    }

    public void editarArticulo(Articulo articulo, String nuevoTitulo, String nuevoContenido, Categoria nuevaCategoria) {
        articulo.setTitulo(nuevoTitulo);
        articulo.setContenido(nuevoContenido);
        articulo.setCategoria(nuevaCategoria);
    }

    public void gestionarComentarios(Articulo articulo, Comentario comentario) {
        // Remueve del artículo
        articulo.getComentarios().remove(comentario);
        // Remueve de los comentarios del usuario que lo creó
        comentario.getUsuario().getComentarios().remove(comentario);
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRol() {
        return rol;
    }
    
}
