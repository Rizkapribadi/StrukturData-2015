import java.io.IOException;
import java.io.FileInputStream; //biar bisa baca berkas
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
/**
 * Write a description of class KopiBerkas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KopiBerkasBuffer
{
    public static void main(String[] args) {
        try {
            KopiBerkasBuffer kp = new KopiBerkasBuffer();
            kp.kopi("rizka.txt","kopi.txt");
        }
        catch (IOException kesalahan) {
            System.out.printf("Terjadi kesalahan: %s", kesalahan);
        }
    }

    /**
     * Constructor untuk objek KopiBerkas
     */

    public void kopi(String sumber, String sasaran) throws IOException {
        FileInputStream sumbernya = null;
        BufferedInputStream source = null;     
        sumbernya = new FileInputStream(sumber);
        source = new BufferedInputStream(sumbernya);

        FileOutputStream kopinya = null;
        BufferedOutputStream copy = null;
        kopinya = new FileOutputStream(sasaran);
        copy = new BufferedOutputStream(kopinya);

        try {

            int karakter = source.read();
            while (karakter != -1) {
                copy.write(karakter);
                karakter = source.read();
            }

            copy.flush();
        } 
        finally {//udah pasti akan dijalankan
            // Tutup stream masukan
            if (source != null)
                source.close();
            if (copy != null)
                copy.close();
        }
    }

}
