import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class SupermercadoConcurrente {
    public static void main(String[] args) {
        //Inicializa la cola de carritos con 25 carritos
        BlockingQueue<Carrito> carritos = new LinkedBlockingQueue<>(25);

        for (int i = 0; i < 25; i++) {
            carritos.add(new Carrito(i));
        }

        //Crear las 3 colas para las cajas
        List<BlockingQueue<Cliente>> cajas = new ArrayList<>();
        cajas.add(new LinkedBlockingQueue<>());
        cajas.add(new LinkedBlockingQueue<>());
        cajas.add(new LinkedBlockingQueue<>());

        //Inicializamos las 3 cajas, cada una como un hilo indepediente
        for (int i = 0; i < 3; i++) {
            new Thread(new Caja(i+1, cajas.get(i), carritos)).start();
        }

        //Creamos un pool para generar los clientes
        ExecutorService generadorClientes = Executors.newCachedThreadPool();
        try {
            while (true) { //Usamos un bucle infinito para generar los clientes
                Thread.sleep(3000);
                generadorClientes.execute(new Cliente(carritos, cajas));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            generadorClientes.shutdown();
        }
    }
}
