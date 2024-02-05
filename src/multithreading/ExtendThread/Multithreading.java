/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading.ExtendThread;

import java.util.logging.Level;
import java.util.logging.Logger;
import multithreading.ImplementsRunnable.*;
import multithreading.*;

/**
 *
 * @author Dan Israel Bobadilla
 */
public class Multithreading {

    public static void main(String[] args) {
        System.out.println("Hilo principal del main: ");
        System.out.println(Thread.currentThread().getName() +" id "+Thread.currentThread().getId());
        // utilizamos el mismo cpu 
        // y se le da a cada hilo un tiempo de ejecución 
        Thread t1 = new Runner1();
        Thread t2 = new Runner2();
        // Creando el daemon de la siguiente manera 
        Thread t3 = new Thread(new DaemonWorker());
        Thread t4 = new Thread(new NormalWorker());
        t3.setDaemon(true);
        //t1.start();
        //t2.start();
        t3.start();
        t4.start();
        // Lo siguiente le dice a java que espere a que el hilo t1 termine pero no el t2 entonces si el t1 termina antes que el t2 
        // java va a imprimir el sout 
        //try {
          //  t1.join();
        //} catch (InterruptedException ex) {
          //  Logger.getLogger(Multithreading.class.getName()).log(Level.SEVERE, null, ex);
        //}
        System.out.println("Los hilos terminaron");// se ejecutara en cualquier parte del print ya que no espera a que terminen los hilos 

    }

}
