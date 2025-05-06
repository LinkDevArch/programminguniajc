package Proyecto;

import java.util.Date;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    // email y contraseña genericos temporales
    private static Administrador admin = new Administrador(1, "admin", "admin", "Johan Bedoya");

    public static void main(String[] args) {
        boolean loop = true;

        while (loop) {
            mostrarMenuPrincipal();
            int opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    verArticulos();
                    break;
                case 2:
                    registrarse();
                    break;
                case 3:
                    iniciarSesionAdministrador();
                    break;
                case 4:
                    iniciarSesionUsuario();
                    break;
                case 5:
                    System.out.println("\nGracias por usar la aplicación. ¡Hasta luego!");
                    loop = false; // Salir del bucle principal
                    break;
                default:
                    System.out.println("\nOpción no válida. Intente de nuevo.\n");
                    break;
            }
        }

        sc.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n==============================");
        System.out.println("      MENÚ PRINCIPAL");
        System.out.println("==============================");
        System.out.println("1. Ver artículos.");
        System.out.println("2. Registrarse.");
        System.out.println("3. Iniciar sesión como administrador.");
        System.out.println("4. Iniciar sesión como usuario registrado.");
        System.out.println("5. Salir de la aplicación."); // Nueva opción para salir
        System.out.println("==============================");
        System.out.print("Seleccione una opción: ");
    }

    private static void verArticulos() {
        if (!RepositorioArticulos.getAllArticulos().isEmpty()) {
            System.out.println("\n==============================");
            System.out.println("      LISTA DE ARTÍCULOS");
            System.out.println("==============================");

            int numerador = 1;
            for (Articulo art : RepositorioArticulos.getAllArticulos()) {
                System.out.println((numerador++) + ". " + art.getTitulo());
            }

            System.out.print("\n¿Desea ver el contenido de algún artículo? Ingrese el número (o 0 para salir): ");
            int numeroArticulo = sc.nextInt();
            sc.nextLine();

            if (numeroArticulo > 0 && numeroArticulo <= RepositorioArticulos.getAllArticulos().size()) {
                Articulo art = RepositorioArticulos.getAllArticulos().get(numeroArticulo - 1);
                System.out.println("\n" + art.getArticuloCompleto());
            } else if (numeroArticulo != 0) {
                System.out.println("\nNúmero de artículo no válido.");
            }
        } else {
            System.out.println("\nNo hay artículos para mostrar.");
        }
    }

    private static void registrarse() {
        System.out.println("\n==============================");
        System.out.println("      REGISTRO DE USUARIO");
        System.out.println("==============================");

        System.out.print("Ingrese su email: ");
        String email = sc.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String password = sc.nextLine();

        Usuario usuario = new Registrado();
        usuario.registrarse(1, email, password);
        
    }

    private static void iniciarSesionAdministrador() {
        System.out.println("\n==============================");
        System.out.println("      INICIO DE SESIÓN ADMIN");
        System.out.println("==============================");

        System.out.print("Ingrese su email: ");
        String email = sc.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String password = sc.nextLine();

        if (email.equals(admin.getEmail()) && password.equals(admin.getPassword())) {
            mostrarMenuAdministrador();
        } else {
            System.out.println("\nCredenciales incorrectas.");
        }
    }

    private static void mostrarMenuAdministrador() {
        boolean salirAdmin = false;

        while (!salirAdmin) {
            System.out.println("\n==============================");
            System.out.println("      MENÚ ADMINISTRADOR");
            System.out.println("==============================");
            System.out.println("1. Escribir un artículo.");
            System.out.println("2. Editar un artículo.");
            System.out.println("3. Eliminar un artículo.");
            System.out.println("4. Eliminar un comentario.");
            System.out.println("5. Salir de administrador.");
            System.out.println("==============================");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    escribirArticulo();
                    break;
                case 2:
                    editarArticulo();
                    break;
                case 3:
                    eliminarArticulo();
                    break;
                case 4:
                    eliminarComentario();
                    break;
                case 5:
                    salirAdmin = true;
                    break;
                default:
                    System.out.println("\nOpción no válida.");
                    break;
            }
        }
    }

    private static void escribirArticulo() {
        System.out.println("\n==============================");
        System.out.println("      CREAR ARTÍCULO");
        System.out.println("==============================");

        System.out.print("Ingrese el título del artículo: ");
        String titulo = sc.nextLine();

        System.out.print("Ingrese la categoria del artículo: ");
        String nombreCategoria = sc.nextLine();
        
        System.out.print("Ingrese el contenido: ");
        String contenido = sc.nextLine();

        System.out.print("Ingrese la imagen: ");
        String imagen = sc.nextLine();

        System.out.print("\n¿Publicar artículo? (S/N): ");
        String publicar = sc.nextLine();

        if (publicar.equalsIgnoreCase("s")) {
            admin.crearArticulo(titulo, nombreCategoria, contenido, imagen, new Date());
            System.out.println("\nArtículo publicado con éxito.");
        } else {
            System.out.println("\nPublicación cancelada.");
        }
    }

    private static void editarArticulo() {
        if (!RepositorioArticulos.getAllArticulos().isEmpty()) {
            System.out.println("\n==============================");
            System.out.println("      EDITAR ARTÍCULO");
            System.out.println("==============================");

            int numerador = 1;
            for (Articulo art : RepositorioArticulos.getAllArticulos()) {
                System.out.println((numerador++) + ". " + art.getTitulo());
            }

            System.out.print("\nSeleccione el número del artículo que desea editar: ");
            int numeroArticulo = sc.nextInt();
            sc.nextLine();

            if (numeroArticulo > 0 && numeroArticulo <= RepositorioArticulos.getAllArticulos().size()) {
                Articulo art = RepositorioArticulos.getAllArticulos().get(numeroArticulo - 1);

                System.out.print("Ingrese el nuevo título: ");
                String nuevoTitulo = sc.nextLine();

                System.out.print("Ingrese el nuevo contenido: ");
                String nuevoContenido = sc.nextLine();

                art.setTitulo(nuevoTitulo);
                art.setContenido(nuevoContenido);

                System.out.println("\nArtículo editado con éxito.");
            } else {
                System.out.println("\nNúmero de artículo no válido.");
            }
        } else {
            System.out.println("\nNo hay artículos para editar.");
        }
    }

    private static void eliminarArticulo() {
        if (!RepositorioArticulos.getAllArticulos().isEmpty()) {
            System.out.println("\n==============================");
            System.out.println("      ELIMINAR ARTÍCULO");
            System.out.println("==============================");

            int numerador = 1;
            for (Articulo art : RepositorioArticulos.getAllArticulos()) {
                System.out.println((numerador++) + ". " + art.getTitulo());
            }

            System.out.print("\nSeleccione el número del artículo que desea eliminar: ");
            int numeroArticulo = sc.nextInt();
            sc.nextLine();

            if (numeroArticulo > 0 && numeroArticulo <= RepositorioArticulos.getAllArticulos().size()) {
                Articulo art = RepositorioArticulos.getAllArticulos().get(numeroArticulo - 1);
                RepositorioArticulos.getAllArticulos().remove(art);

                System.out.println("\nArtículo eliminado con éxito.");
            } else {
                System.out.println("\nNúmero de artículo no válido.");
            }
        } else {
            System.out.println("\nNo hay artículos para eliminar.");
        }
    }

    private static void eliminarComentario() {
        if (!RepositorioArticulos.getAllArticulos().isEmpty()) {
            System.out.println("\n==============================");
            System.out.println("      ELIMINAR COMENTARIO");
            System.out.println("==============================");

            int numerador = 1;
            for (Articulo art : RepositorioArticulos.getAllArticulos()) {
                System.out.println((numerador++) + ". " + art.getTitulo());
            }

            System.out.print("\nSeleccione el número del artículo: ");
            int numeroArticulo = sc.nextInt();
            sc.nextLine();

            if (numeroArticulo > 0 && numeroArticulo <= RepositorioArticulos.getAllArticulos().size()) {
                Articulo art = RepositorioArticulos.getAllArticulos().get(numeroArticulo - 1);

                if (!art.getComentarios().isEmpty()) {
                    System.out.println("\nComentarios del artículo:");
                    int comentarioNumerador = 1;
                    for (Comentario comentario : art.getComentarios()) {
                        System.out.println((comentarioNumerador++) + ". " + comentario.getContenido() + " (por: " + comentario.getUsuario().getEmail() + ")");
                    }

                    System.out.print("\nSeleccione el número del comentario que desea eliminar: ");
                    int numeroComentario = sc.nextInt();
                    sc.nextLine();

                    if (numeroComentario > 0 && numeroComentario <= art.getComentarios().size()) {
                        Comentario comentario = art.getComentarios().get(numeroComentario - 1);
                        art.getComentarios().remove(comentario);

                        System.out.println("\nComentario eliminado con éxito.");
                    } else {
                        System.out.println("\nNúmero de comentario no válido.");
                    }
                } else {
                    System.out.println("\nNo hay comentarios en este artículo.");
                }
            } else {
                System.out.println("\nNúmero de artículo no válido.");
            }
        } else {
            System.out.println("\nNo hay artículos disponibles.");
        }
    }

    private static void iniciarSesionUsuario() {
        System.out.println("\n==============================");
        System.out.println("      INICIO DE SESIÓN USUARIO");
        System.out.println("==============================");

        System.out.print("Ingrese su email: ");
        String email = sc.nextLine();

        System.out.print("Ingrese su contraseña: ");
        String password = sc.nextLine();

        for (Registrado user : RepositorioUsuario.getAllUsuarios()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                System.out.println("\nInicio de sesión exitoso.");
                mostrarMenuUsuario(user);
                return;
            }
        }

        System.out.println("\nCredenciales incorrectas.");
    }

    private static void mostrarMenuUsuario(Registrado usuario) {
        boolean userLoggedIn = true;

        while (userLoggedIn) {
            System.out.println("\n==============================");
            System.out.println("      MENÚ USUARIO");
            System.out.println("==============================");
            System.out.println("1. Suscribirse.");
            System.out.println("2. Ver artículos y comentar.");
            System.out.println("3. Cerrar sesión.");
            System.out.println("==============================");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    usuario.suscribirse();
                    break;
                case 2:
                    verYComentarArticulos(usuario);
                    break;
                case 3:
                    userLoggedIn = false;
                    break;
                default:
                    System.out.println("\nOpción no válida.");
                    break;
            }
        }
    }

    private static void verYComentarArticulos(Registrado usuario) {
        if (!RepositorioArticulos.getAllArticulos().isEmpty()) {
            System.out.println("\n==============================");
            System.out.println("      LISTA DE ARTÍCULOS");
            System.out.println("==============================");

            int numerador = 1;
            for (Articulo art : RepositorioArticulos.getAllArticulos()) {
                System.out.println((numerador++) + ". " + art.getTitulo());
            }

            System.out.print("\n¿Desea ver el contenido de algún artículo? Ingrese el número (o 0 para salir): ");
            int numeroArticulo = sc.nextInt();
            sc.nextLine();

            if (numeroArticulo > 0 && numeroArticulo <= RepositorioArticulos.getAllArticulos().size()) {
                Articulo art = RepositorioArticulos.getAllArticulos().get(numeroArticulo - 1);
                System.out.println("\n" + art.getArticuloCompleto());

                System.out.println("\nComentarios:");
                for (Comentario comentario : art.getComentarios()) {
                    System.out.println("- " + comentario.getContenido() + " (por: " + comentario.getUsuario().getEmail() + ")");
                }

                System.out.print("\n¿Desea comentar este artículo? (S/N): ");
                String comentar = sc.nextLine();

                if (comentar.equalsIgnoreCase("s")) {
                    System.out.print("Ingrese su comentario: ");
                    String contenidoComentario = sc.nextLine();
                    usuario.escribirComentario(art, contenidoComentario);
                    System.out.println("\nComentario agregado con éxito.");
                }
            } else if (numeroArticulo != 0) {
                System.out.println("\nNúmero de artículo no válido.");
            }
        } else {
            System.out.println("\nNo hay artículos para mostrar.");
        }
    }
}