import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.util.Scanner;

public class Client {
    public void chat() 
                throws UnknownHostException, IOException {
        Socket socket = new Socket("localhost", 33333);
        String perintah=null;
        
        try {
            Reader masukan = null;
            BufferedReader masukanBuff=null;
            String baris = null;
    
            Scanner keyboard = new Scanner(System.in);
            System.out.print("Perintah: ");
            perintah = keyboard.nextLine();
            
            if(perintah.equalsIgnoreCase("WAKTU")||perintah.equalsIgnoreCase("SIAPA")){
            
                Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream()); 
                BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter);
                keluaranBuff.write(perintah);
                keluaranBuff.write("\n");
                keluaranBuff.flush();
                
   
                System.out.print("");
                masukan = new InputStreamReader(socket.getInputStream()); 
                masukanBuff = new BufferedReader(masukan);
                baris = masukanBuff.readLine();
                System.out.println(""+baris);
                
                
            }else{
        
                Writer keluaranWriter = new OutputStreamWriter(socket.getOutputStream()); 
                BufferedWriter keluaranBuff = new BufferedWriter(keluaranWriter);
                keluaranBuff.write(perintah);
                keluaranBuff.write("\n");
                keluaranBuff.flush();
                masukan = new InputStreamReader(socket.getInputStream()); 
                masukanBuff = new BufferedReader(masukan);
                baris = masukanBuff.readLine();
                System.out.println(""+baris);
            }
       
        }
        catch(IOException salah) {
            System.out.println(salah);
        }
        
        finally {
            if (socket != null)
            socket.close();
        }
    }
}