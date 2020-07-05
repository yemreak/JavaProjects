
package dosyaişlemleri;

import java.io.Serializable;
// Object output tream tarafından yazılabilir olduğunu ifade etmek için serializable implements edilmeli.
public class Kişi implements Serializable{
    
    String isim, soyisim;
    int yaş;
    
    public Kişi(String isim, String soyisim, int yaş){
        this.isim = isim;
        this.soyisim = soyisim;
        this.yaş = yaş;
    }
}
