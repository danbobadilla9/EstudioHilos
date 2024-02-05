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
public class Runner1 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 20; ++i) {
            try {
                sleep(500);
                System.out.println("Runner1: " + i);
            } catch (InterruptedException ex) {
                Logger.getLogger(Runner1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
