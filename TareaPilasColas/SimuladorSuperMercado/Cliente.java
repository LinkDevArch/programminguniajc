import java.util.concurrent.BlockingQueue;
import java.util.List;

public class Cliente implements Runnable {
    private final BlockingQueue<Carrito> carritos; //Cola de carritos
    private final List<BlockingQueue<Cliente>> cajas; //Lista de colas de las 3 cajas
    private Carrito carrito; //Carrito asignado al cliente

    public Cliente(BlockingQueue<Carrito> carritos, List<BlockingQueue<Cliente>> cajas) {
        this.carritos = carritos;
        this.cajas = cajas;
    }

    @Override
    public void run() {
        try {
            //Toma un carrito
            carrito = carritos.take();
            System.out.println("Cliente"+Thread.currentThread().threadId() + " tomó carrito " + carrito.getId());

            //Simula el tiempo de compra (entre 1 y 5 segundos)
            Thread.sleep((long)(Math.random() * 5000 + 1000));
            System.out.println("Cliente " + Thread.currentThread().threadId() + " terminó de comprar");

            //Buscar la caja con menos clientes
            BlockingQueue<Cliente> cajaElegida = cajas.get(0);
            for (BlockingQueue<Cliente> caja : cajas) {
                if (caja.size() < cajaElegida.size()) {
                    cajaElegida=caja;
                }
            }

            //Se pone en la cola de la caja elegida (bloquea si esta llena)
            cajaElegida.put(this);
            System.out.println("Cliente " + Thread.currentThread().threadId() + " entro a caja " + (cajas.indexOf(cajaElegida)+1));

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public Carrito getCarrito () {
        return carrito;
    }
}
