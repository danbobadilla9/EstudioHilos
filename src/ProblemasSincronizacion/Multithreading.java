/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProblemasSincronizacion;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan Israel Bobadilla
 */
public class Multithreading {

    // el objeto Multithreading solo tiene un monitor, los metodos increment no pueden ser ejecutados al mismo tiempo,
    // tienen que esperar a que el monitor se libere para que otros hilos puedan ajecutarlo 
    public static int counter = 0;
    public static int counter2 = 0;
    public static int counter3 = 0;
    
    private static final Object lock2 = new Object();

    // solo ejecuta el metodo un solo hilo y ya 
    public static synchronized void increment() {
        counter++;
    }

    public static void increment2() {
        //class level locking 
        synchronized (Multithreading.class) {
            counter2++;
        }
    }
    
    public static void increment3() {
        //class level locking
        synchronized (lock2) {
            counter3++;
        }
    }

    public static void process() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; ++i) {
                    //counter++;
                    increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; ++i) {
                    //counter++;
                    increment2();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; ++i) {
                    //counter++;
                    increment();
                }
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; ++i) {
                    //counter++;
                    increment3();
                }
            }
        });
        Thread t5 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; ++i) {
                    //counter++;
                    increment();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Multithreading.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El contador es: " + counter);
        System.out.println("El contador2 es: " + counter2);
        System.out.println("El contador3 es: " + counter3);
    }

    public static void main(String[] args) {
        // veremos que el contador cambia su valor dependiendo de la ocasion debido a que comparten el mismo heap
        process();
    }
}
