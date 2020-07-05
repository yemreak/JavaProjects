/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multitimeprogramming;

/**
 *
 * @author Yunus Emre
 */
public class İşlem {

    int sonuç;

    boolean tamamlandı;

    public İşlem() {
        sonuç = 0;

        tamamlandı = false;
    }

    public int getSonuç() {
        return sonuç;
    }

    public void setSonuç(int sonuç) {
        this.sonuç = sonuç;
    }

    public boolean isTamamlandı() {
        return tamamlandı;
    }

    public void setTamamlandı(boolean tamamlandı) {
        this.tamamlandı = tamamlandı;
    }
    
}
