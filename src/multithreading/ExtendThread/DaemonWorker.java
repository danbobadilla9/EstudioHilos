/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading.ExtendThread;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan Israel Bobadilla
 */
public class DaemonWorker implements Runnable{

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(DaemonWorker.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Daemon thread is running...");
        }
    }
    
}
