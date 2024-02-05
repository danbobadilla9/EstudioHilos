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
public class Runner2 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; ++i) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Runner2.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Runner2: " + i);
        }
    }
}
