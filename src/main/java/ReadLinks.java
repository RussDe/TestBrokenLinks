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


    public ArrayList<String> readLinks(String page) {
        System.out.print("Links reading ... ");
        ArrayList<String> array = new ArrayList<String>();;
        DRIVER.get(page);
        List<WebElement> links = DRIVER.findElements(By.cssSelector("a"));
        for (WebElement element : links) {
            array.add(element.getAttribute("href"));
        }
    DRIVER.close();
    System.out.println(FontColor.ANSI_GREEN+"Done!"+FontColor.ANSI_RESET);
    return array;
}
}
