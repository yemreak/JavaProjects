package deneme;
import java.util.Date;
public class İşçi extends İnsan {
    String meslek;
    String bilinendil;
    public İşçi(String değer1,String değer2,Date değer3,String değer4,String değer5){
        super(değer1,değer2,değer3);
        this.meslek=değer4;
        this.bilinendil=değer5;
    }
}
