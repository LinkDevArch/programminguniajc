package Proyecto;

import java.util.ArrayList;
import java.util.List;

abstract class Usuario {
    protected int id;
    protected String email;
    protected String password;
    protected List<Comentario> comentarios = new ArrayList<>();
    protected List<Articulo> articulosPorUsuario = new ArrayList<>();


    public Usuario(){

    }

    public Usuario(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public void registrarse(int id , String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        Registrado datosUsuarioAregistrar = new Registrado(id, email, password);
        RepositorioUsuario.registrarUsuario(datosUsuarioAregistrar);

        System.out.println("Usuario Registrado Exitosamente Con: \n"+email+"\n"+password);
    }

    public String iniciarSesion (String email, String password){
        if (this.email==email && this.password==password) 
            return "Sesion iniciada";
        else
            return"";
    }

    public String recuperarContrasena(String email, String newPassword) {

        if (this.email==email) {
            this.password=newPassword;
            return "Contraseña Actualizada";
        }
        else
            return "Contraseña Actualizada";
    }

    public int getId () {
        return this.id;
    }

    public void addComentarioUsuario(Comentario comentario) {
        comentario.setUsuario(this);
        comentarios.add(comentario);
    }

    void addArticulo(Articulo articulo) {
        articulosPorUsuario.add(articulo);
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    

}
