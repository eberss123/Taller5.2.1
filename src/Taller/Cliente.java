/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Taller;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author ebers
 */
public class Cliente implements Runnable {
    private final BlockingQueue<Pedido> colaDePedidos;
    private final int idCliente;

    public Cliente(BlockingQueue<Pedido> colaDePedidos, int idCliente) {
        this.colaDePedidos = colaDePedidos;
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Pedido pedido = new Pedido(idCliente * 10 + i, "Pedido " + (idCliente * 10 + i));
                colaDePedidos.put(pedido);
                System.out.println("Cliente " + idCliente + " ha hecho el " + pedido.getDescripcion());
                Thread.sleep((int) (Math.random() * 1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
