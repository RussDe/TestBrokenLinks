import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

//read links from pages
class ReadLinks {
    private final WebDriver DRIVER = new HtmlUnitDriver();


    public HashMap<URL, ArrayList<String>> readLinks(HashSet<URL> urlPages) {
        System.out.print("Links reading ... ");
        ArrayList<String> array;

        HashMap<URL, ArrayList<String>> mapLinks = new HashMap();
        for (URL item : urlPages) {
            DRIVER.get(item.toString());
            array = new ArrayList<String>();
            List<WebElement> links = DRIVER.findElements(By.cssSelector("a"));
            for (WebElement element : links) {
                array.add(element.getAttribute("href"));
            }
            mapLinks.put(item, array);
        }
        DRIVER.close();
        System.out.println(FontColor.ANSI_GREEN + "Done!" + FontColor.ANSI_RESET);
        return mapLinks;
    }
}
