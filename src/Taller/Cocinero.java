
package Taller;

import java.util.concurrent.BlockingQueue;

public class Cocinero implements Runnable {
      private final BlockingQueue<Pedido> colaDePedidos;

    public Cocinero(BlockingQueue<Pedido> colaDePedidos) {
        this.colaDePedidos = colaDePedidos;
    }

    public void run() {
        try {
            while (true) {
                Pedido pedido = colaDePedidos.take();
                System.out.println("Cocinero está preparando el " + pedido.getDescripcion());
                Thread.sleep((int) (Math.random() * 2000));
                System.out.println("Cocinero ha completado el " + pedido.getDescripcion());
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
