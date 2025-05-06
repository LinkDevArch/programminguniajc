package Proyecto;

import java.util.Date;

public class Comentario {

    private Usuario usuario;
    private String contenido;
    private Date fechaComentario;

    public Comentario(Usuario usuario, String contenido, Date fechaComentario) {
        this.usuario = usuario;
        this.contenido = contenido;
        this.fechaComentario = fechaComentario;
    }

    //Metodos set

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    //Metodos get

    public Usuario getUsuario() {
        return usuario;
    }

    public String getContenido() {
        return contenido;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    

    
    
}
