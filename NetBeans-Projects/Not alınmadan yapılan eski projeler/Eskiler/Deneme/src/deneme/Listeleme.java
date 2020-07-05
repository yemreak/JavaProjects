package deneme;
import java.util.Scanner;
public class Listeleme {
    int veri1;
    Scanner veri;
    int liste[];
    public Listeleme(){
    this.veri= new Scanner(System.in);
    this.veri1=this.veri.nextInt();
    this.liste = new int[veri1];
    System.out.println("Liste uzunluğu ->"+this.liste.length);
    }

    public void mathIslemi() {
        System.out.println(this.veri1);
    }
    
};
