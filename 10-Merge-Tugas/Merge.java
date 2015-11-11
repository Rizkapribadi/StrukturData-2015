import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class Merge
{
    public void merge(String file1,String file2, String file3,String sasaran)throws IOException
    {
        FileInputStream sumbernya1 = null;
        FileInputStream sumbernya2 = null;
        FileInputStream sumbernya3 = null;
        FileOutputStream copy = null;

        try {

            sumbernya1 = new FileInputStream(file1);
            sumbernya2 = new FileInputStream(file2);
            sumbernya3 = new FileInputStream(file3);
            copy = new FileOutputStream(sasaran);

            int karakter = sumbernya1.read();

            while (karakter != -1) {
                copy.write(karakter);
                karakter =sumbernya1.read();
            }

            copy = new FileOutputStream(sasaran,true);
            karakter =  sumbernya2.read();
            while (karakter != -1) {
                copy.write(karakter);
                karakter =  sumbernya2.read();
            }

            copy = new FileOutputStream(sasaran,true);
            karakter =  sumbernya3.read();
            while (karakter != -1) {
                copy.write(karakter);
                karakter =  sumbernya3.read();
            }

            copy.flush();
        } 
        finally {//udah pasti akan dijalankan
           
            if ( sumbernya1 != null)
                sumbernya1.close();
            if ( sumbernya2  != null)
                sumbernya2 .close();
            if (sumbernya3 != null)
                sumbernya3.close();
            if (copy != null)
                copy.close();
        }
    }

    public static void main(String[] args) {
        try {
            Merge mrg = new Merge();
            mrg.merge("satu.txt", "dua.txt","tiga.txt","hasilnya.txt");
        }
        catch (IOException kesalahan) {
            System.out.printf("Terjadi kesalahan: %s", kesalahan);
        }
    }
}
