/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreading;

/**
 *
 * @author Dan Israel Bobadilla
 */
public class Multithreading {

    public static void main(String[] args) {
        // sequential processing
        // Java espera a que runner 1 termine de ejecutarse para despues ejecutar al runner 2 
        Runner1 runner1 = new Runner1();
        Runner2 runner2 = new Runner2();
        
        runner1.execute();
        runner2.execute();
    }
    
}
