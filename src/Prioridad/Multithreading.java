/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prioridad;

/**
 *
 * @author Dan Israel Bobadilla
 */
class Worker implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }

}

public class Multithreading {

    public static void main(String[] args) {

        Thread t = new Thread(new Worker());
        t.setPriority(Thread.MAX_PRIORITY);
        t.start();
        System.out.println("Esto es el thread main");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        System.out.println(Thread.currentThread().getPriority());
    }
}
