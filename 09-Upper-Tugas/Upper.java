import java.io.IOException;
import java.io.FileInputStream; //biar bisa baca berkas
import java.io.FileOutputStream;
import java.io.*;
/**
 * Write a description of class Upper here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Upper
{
    public static void main(String[] args) {
        try {
            Upper up = new Upper();
            up.upper("rizka.txt", "upper.txt");
        }
        catch (IOException kesalahan) {
            System.out.printf("Terjadi kesalahan: %s", kesalahan);
        }
    }

    /**
     * Constructor untuk objects kelas upper
     */

    public void upper(String sumber, String sasaran) throws IOException {
        // untuk baca berkas 
        FileInputStream sumbernya = null;
        FileOutputStream copy = null;

        try {
            sumbernya = new FileInputStream(sumber);
            copy = new FileOutputStream(sasaran);

            int karakter = sumbernya.read();
            // Selama masih ada data yang masih bisa dibaca
            while (karakter != -1) {
                karakter=Character.toUpperCase(karakter);
                copy.write(karakter);
                karakter = sumbernya.read();
            }

            copy.flush();
        } 
        finally {//udah dijamin akan dijalankan
            // Tutup stream masukan
            if (sumbernya != null)
                sumbernya.close();
            if (copy != null)
                copy.close();
        }
    }

}
