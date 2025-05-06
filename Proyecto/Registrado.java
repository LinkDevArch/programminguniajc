package Proyecto;

import java.util.Date;

public class Registrado extends Usuario {

    protected boolean suscripcionActiva = false;

    public Registrado(){
        super();
    }

    public Registrado (int id, String email, String password) {
        super(id, email, password);
    }

    //Puede escribir comentarios.

    public void escribirComentario (Articulo articulo, String contenido) {
        Comentario c = new Comentario(this, contenido, new Date());
        articulo.addComentario(c);
        addComentarioUsuario(c);

    }

    public void suscribirse() {
        suscripcionActiva=true;
        System.out.println("Suscripcion activa, gracias por su compra!");
    }

    public void getSuscripcion () {
        if (suscripcionActiva = true)
            System.out.println("Suscripcion Actual: Activa");
        else
            System.out.println("Suscripcion actual: Sin suscripción");
    }

    
}
