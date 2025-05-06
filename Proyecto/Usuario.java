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

    public void registrarse(int id, String email, String password) {
        this.id = id;
    
        // Verificar que el email no sea nulo o vacío
        if (email == null || email.isEmpty()) {
            System.out.println("El email no puede estar vacío");
            return;
        }
    
        // Verificar que el email tenga un formato válido
        if (!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            System.out.println("Formato de email inválido");
            return;
        }
    
        // Asignar el email si pasa las validaciones
        this.email = email;
    
        // Verificar que la contraseña no sea nula o vacía
        if (password == null || password.isEmpty()) {
            System.out.println("La contraseña no puede estar vacía");
            return;
        }
    
        // Verificar que la contraseña tenga al menos 8 caracteres
        if (password.length() < 8) {
            System.out.println("La contraseña debe tener al menos 8 caracteres");
            return;
        }
    
        // Verificar que la contraseña contenga al menos una letra y un número
        if (!password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            System.out.println("La contraseña debe contener al menos una letra y un número");
            return;
        }
    
        // Asignar la contraseña si pasa las validaciones
        this.password = password;
    
        // Crear un nuevo usuario registrado y agregarlo al repositorio
        Registrado datosUsuarioAregistrar = new Registrado(id, email, password);
        RepositorioUsuario.registrarUsuario(datosUsuarioAregistrar);
    
        System.out.println("Usuario registrado exitosamente con: \nEmail: " + email);
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
