
/**
 * Write a description of class Utama here.
 * 
 * @author Rizka Pribadi
 * @NIM :1408107010010
 */

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Utama
{
    public static void main(String[] args) {
        try {
            Chat kirim = new Chat();
            Scanner input = new Scanner(System.in);
            
            System.out.print("Client: ");
            String kalimat = new String();
            kalimat = input.nextLine();
            
            kirim.chat(kalimat);
        }
        catch (UnknownHostException ex) {
            System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }


}
