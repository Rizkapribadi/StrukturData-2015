import java.util.Scanner;
import java.net.Socket;
import java.net.InetAddress;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
public class ProsesThread implements Runnable{
    private String angka;
    private Socket koneksi;
    public ProsesThread(Socket koneksiKiriman, int angka) {
        koneksi = koneksiKiriman;
        this.angka = ""+angka;
    }

    public void run() {
        try{
            if (koneksi != null)
                prosesPermintaanClient();
        }catch(IOException err) {
            System.out.println(err);
        }
    }

    private void prosesPermintaanClient()
    throws IOException {
        String ip = koneksi.getInetAddress().getHostAddress();
        System.out.println("Dari: " + ip);
        int i = 0;
        String pesanServer = null;
        OutputStream keluaran =null;
        BufferedWriter keluaranBuf = null;
        for(i=0; i<3; i++){
            // Ambil dan tampilkan masukan
            InputStream masukan = koneksi.getInputStream();
            BufferedReader masukanReader = new BufferedReader(new InputStreamReader(masukan));
            String baris = masukanReader.readLine();
            System.out.println(baris);
            if(angka.equalsIgnoreCase(baris))
                pesanServer="Benar";
            else
                pesanServer="Salah";
            // Kirim ke client
            keluaran = koneksi.getOutputStream();
            keluaranBuf = new BufferedWriter(new OutputStreamWriter(keluaran));
            keluaranBuf.write(pesanServer);
            keluaranBuf.newLine();
            keluaranBuf.flush();
            if(pesanServer.equalsIgnoreCase("Benar"))
                break;
        }
        if(i==3){
            pesanServer="  "+angka;
            keluaran = koneksi.getOutputStream();
            keluaranBuf = new BufferedWriter (new OutputStreamWriter(keluaran));
            keluaranBuf.write(pesanServer);
            keluaranBuf.newLine();
            keluaranBuf.flush();
        }
        // Tunggu kirim balasan client
    }
}