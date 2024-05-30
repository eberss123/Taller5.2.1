/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Taller;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author ebers
 */
public class GestionDePedidosRestaurante {
     public static void main(String[] args) {
        BlockingQueue<Pedido> colaDePedidos = new LinkedBlockingQueue<>();

        // Crear un pool de hilos
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Iniciar hilos de clientes
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Cliente(colaDePedidos, i));
        }

        // Iniciar hilos de cocineros
        for (int i = 0; i < 2; i++) {
            executorService.execute(new Cocinero(colaDePedidos));
        }

        // Apagar el executor después de una demora para permitir la simulación
        executorService.shutdown();
    }
}
