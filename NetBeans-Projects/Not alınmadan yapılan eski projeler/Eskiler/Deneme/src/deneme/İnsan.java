package deneme;
import java.util.Date;

public class İnsan {
    String isim;
    String soyisim;
    Date doğum;
    public İnsan(String değer1,String değer2,Date değer3){
        this.isim=değer1;
        this.soyisim=değer2;
        this.doğum=değer3;
    }
    public void yazdır(){
        System.out.println(this.isim+" "+this.soyisim+" / "+this.doğum);
    }
    public int yaş(){
        Date bugün=new Date();
        return bugün.getYear()-doğum.getYear();
    }
    
}
