package deneme;
import java.util.EnumSet;
import java.util.Scanner;
import java.util.Date;
public class Deneme {
    
    public static void main(String[] args) {
        Date d1 = new Date();
        d1.setDate(14);
        d1.setMonth(0);
        d1.setYear(97);        
        İnsan insan1= new İnsan("Yunus Emre","Ak",d1);
        insan1.yazdır();
        System.out.println(insan1.yaş());
        
        
        
        
        /*System.out.println("Silan'in yaptigi kek ne aromalıdır ?");
        for(Kek Silan:Kek.values()){
            System.out.println(Silan.yazdır());
        }
        System.out.println("-----------------\nYanlış şıklar :");
        for (Kek Silan : EnumSet.range(Kek.Kek2,Kek.Kek3)) {
            System.out.println(Silan.yazdır());
        } /*Scanner input=new Scanner (System.in);
        String sayi=input.nextLine();
        System.out.println("Niye "+sayi+ " yazdın şimdi ?");
        Ders d1 = new Ders("Matematik","Ahmet",15);
        input = new Scanner (System.in);
        String sayi1=input.nextLine();
        System.out.println(sayi+"+++"+sayi1); 
        Listeleme a=new Listeleme();
        a.mathIslemi();*/
    }
    
}