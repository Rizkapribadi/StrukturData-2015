public class Alien extends Komodo implements Tumbuhan
{
    
    public boolean berbuah()
    {
        return true;
    }
    public String suara()
    {
        String suara= new String ("Bip");
        return suara;
    }
    public boolean merayap()
    {
        return false;
    }
}