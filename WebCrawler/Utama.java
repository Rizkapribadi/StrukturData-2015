import java.io.IOException;
import java.net.UnknownHostException;

public class Utama {
    public static void main(String[] args) {
        try {
           Webcrawler tanya = new Webcrawler();
            tanya.Webcrawler("GET index.html.newline");
        }
        catch (UnknownHostException ex) {
            System.err.println(ex);
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}