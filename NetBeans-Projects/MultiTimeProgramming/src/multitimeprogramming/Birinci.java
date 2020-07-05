/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitimeprogramming;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Runnable, eş zamanlı programlama için
 * @author Yunus Emre
 */
public class Birinci implements Runnable{

    İşlem birimİşlem;
    
    public Birinci(İşlem gelenİşlem){
        this.birimİşlem = gelenİşlem;
    }
    
    /**
     * Run methodu doğrudan ulaşılabilir bir halde değil. (static olmazsa)
     */
    @Override
    public void run() {
       
    }
    
}
