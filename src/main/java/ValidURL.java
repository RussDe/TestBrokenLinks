import java.net.MalformedURLException;
import java.net.URL;

//check if URL is valid
public class ValidURL {

    public static boolean validURL(String urlLink) {
        try {
            URL url = new URL(urlLink);
            return true;
        }
        catch (MalformedURLException e) {
            return false;
        }
    }
}
