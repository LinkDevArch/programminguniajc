import java.util.concurrent.BlockingQueue;

public class Caja implements Runnable {
    private final int numero; //Identificador de caja
    private final BlockingQueue<Cliente> cola;
    private final BlockingQueue<Carrito> carritos;

    public Caja (int numero, BlockingQueue<Cliente> cola, BlockingQueue<Carrito> carritos) {
        this.numero = numero;
        this.cola = cola;
        this.carritos = carritos;
    }

    @Override
    public void run() {
        try {
            while (true) { //La caja siempre esta activa
                Cliente cliente = cola.take(); //Toma el primero cliente
                System.out.println("Caja " + numero + " atendiendo cliente " + Thread.currentThread().threadId());

                //Simula tiempo de pago entre 1 y 5 segundos
                Thread.sleep((long)(Math.random() * 5000 + 1000));

                //Libera el carrito del cliente
                carritos.put(cliente.getCarrito());
                System.out.println("Caja " + numero + " libero carrito " + cliente.getCarrito().getId());

            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
