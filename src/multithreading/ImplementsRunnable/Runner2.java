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
public class Runner2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 20; ++i) {
            System.out.println("Runner2: " + i);
        }
    }
}
