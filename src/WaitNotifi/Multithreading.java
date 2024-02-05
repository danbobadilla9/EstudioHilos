/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WaitNotifi;

import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

/**
 *
 * @author Dan Israel Bobadilla
 */
class Process {

    // ellos utilizan el mismo monitor por lo que wait le dice que se libera y puede ser utilizado
    // en el metodo consume y cuando encontramos le notify esto le indica al monitor que puede volver con el primer metodo
    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("Running the produce method...");
            wait();
            System.out.println("Again in the producer method...");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this) {
            System.out.println("Consummer method is executed...");
            notify();
            // al llamar el metodo no se termina el metodo en sí, va a ejecutar lo que tenga delante hasta que termine el metodo y solo así
            // volvera al metodo produce 
            Thread.sleep(1000);
        }
    }

}

public class Multithreading {

    public static void main(String[] args) {
        Process process = new Process();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.produce();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Multithreading.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    process.consume();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Multithreading.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        t1.start();
        t2.start();
    }

}
