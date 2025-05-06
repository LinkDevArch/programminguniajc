package Proyecto;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Articulo {
    private Administrador autor;
    private String titulo;
    private String contenido;
    private String imagen;
    private Date fechaPublicacion;
    private Categoria categoria;
    private List<Comentario> comentarios = new ArrayList<>();

    public Articulo(Administrador autor, Categoria categoria, String titulo, String contenido, String imagen, Date fechaPublicacion) {
        this.autor = autor;
        this.titulo = titulo;
        this.contenido = contenido;
        this.categoria = categoria;
        this.imagen = imagen;
        this.fechaPublicacion = fechaPublicacion;

        if (categoria != null) {
            categoria.agregarArticulo(this);
        }
    }

    public void addComentario(Comentario comentario) {
        comentarios.add(comentario);
    }

    //Metodos set

    public void setAutor(Administrador autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    //Metodos get

    public String getArticuloCompleto() {
        return "Título: " + titulo + "\n" +
               "Autor: " + autor.getNombreCompleto() + "\n" +
               "Categoría: " + (categoria != null ? categoria.getNombre() : "Sin categoría") + "\n" +
               "Contenido:\n" + contenido + "\n" +
               "Imagen: " + (imagen != null && !imagen.isEmpty() ? imagen : "No disponible") + "\n";
    }

    public Usuario getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public String getImagen() {
        return imagen;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    

    


}
