
package ders.insan;

import java.util.Scanner;

public class Array {
    
    Scanner veri = new Scanner(System.in);
    
    public Array(){
        
        System.out.println("-> Array class'ı açıldı");
        
        
        int dboyut = this.veri.nextInt();
        int[] a = new int[dboyut];
        
        for (int i=0; i<dboyut ; i++){
            System.err.println((i+1) + "-> " + a[i]); // Kırmızı renkle yazdırma
        }
    }
}
