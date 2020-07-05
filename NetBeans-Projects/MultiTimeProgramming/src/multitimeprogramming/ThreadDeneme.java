/**
 * Static öğeler sabit öğelerdir, program açıldığı anda tanımlanır.
 */
package multitimeprogramming;

/**
 *
 * @author Yunus Emre
 */
public class ThreadDeneme {
    
    /**
     * @param args the command line arguments
     * Main static olmazsa diğer öğelere erişebiliyor.
     */
    public static void main(String[] args) {
        Thread t1 = new Thread(new Birinci());
        t1.start();
        
        Thread t2 = new Thread(new İkinci());
        t2.start();
    }
    
    /**
     * Thread denemesi için classlarda değişken tanımlama
     */
    static Birinci bir = new Birinci();
    static İkinci iki;
    
    public ThreadDeneme(){
        bir = new Birinci();
        iki = new İkinci();
    }
}
