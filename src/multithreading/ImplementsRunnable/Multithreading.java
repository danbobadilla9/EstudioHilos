/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading.ImplementsRunnable;

import multithreading.*;

/**
 *
 * @author Dan Israel Bobadilla
 */
public class Multithreading {

    public static void main(String[] args) {
        // utilizamos el mismo cpu 
        // y se le da a cada hilo un tiempo de ejecución 
        Thread t1 = new Thread(new Runner1());
        Thread t2 = new Thread(new Runner2());
        // Podemos crear el trhead al aire 
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 20; ++i) {
                    System.out.println("Runner3: " + i);
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }

}
