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
    
    public static int counter = 0;
    
    public static void process(){
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i= 0; i < 100; ++i){
                    counter++;
                }
            }
        });
        
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i= 0; i < 50; ++i){
                    counter++;
                }
            }
        });
        
        Thread t3 = new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i= 0; i < 100; ++i){
                    counter++;
                }
            }
        });
        Thread t4 = new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i= 0; i < 50; ++i){
                    counter++;
                }
            }
        });
        Thread t5 = new Thread(new Runnable(){
            @Override
            public void run(){
                for(int i= 0; i < 100; ++i){
                    counter++;
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
        System.out.println("El contador es: "+counter);
    }
    
    public static void main(String[] args) {
        process();
    }
}
