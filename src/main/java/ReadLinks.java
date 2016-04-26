import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;

//read links from pages
public class ReadLinks {
    WebDriver driver = new HtmlUnitDriver();


    public HashMap<URL, String> readLinks(HashSet<URL> urlPages) {
        System.out.print("Links reading ... ");

        HashMap<URL, String> mapLinks = new HashMap<URL, String>();
        for (URL item : urlPages) {
            driver.get(item.toString());
            mapLinks.put(item, driver.getTitle().toString());
        }
        driver.close();
        System.out.println(FontColor.ANSI_GREEN + "Done!" + FontColor.ANSI_RESET);
        return mapLinks;
    }
}
