/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsumerAndProducer.Ejemplosync;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dan Israel Bobadilla
 */
public class Panaderia {
   private String pan;
   private boolean disponible;
   
   public synchronized void hornear(String masa){
       while(disponible){
           try {
               wait();
           } catch (InterruptedException ex) {
               Logger.getLogger(Panaderia.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       this.pan = masa;
       System.out.println("Panadero Hornea: "+this.pan);
       this.disponible = true;
       notify();
   }
   
   public synchronized String consumir(){
       while(!disponible){
           try {
               wait();
           } catch (InterruptedException ex) {
               Logger.getLogger(Panaderia.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       System.out.println("Cliente consume: "+this.pan);
       this.disponible = false;
       notify();
       return pan;
   }
           
}
