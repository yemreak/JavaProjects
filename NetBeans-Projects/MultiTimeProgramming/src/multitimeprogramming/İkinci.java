/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitimeprogramming;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yunus Emre
 */
public class İkinci implements Runnable{
        
    private int sayı = 50;
    
    public İkinci(){
        
    }

    @Override
    public void run() {
     while(sayı > 35){
         try {
             System.out.println("Geri x: " + sayı);
             sayı--;
             
             // Geçiçi bekleme
             Thread.sleep(1000);
         } 
         catch (InterruptedException ex) {
             Logger.getLogger(İkinci.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }
    
    
}
