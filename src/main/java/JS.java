import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

//playing with JS
class JS {
    WebDriver driver = new FirefoxDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;

    void jsAction(String page, String fileName) throws IOException {
        driver.get(page);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        File file = new File(fileName);
        FileReader fw = new FileReader(file);
        BufferedReader br = new BufferedReader(fw);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> links = driver.findElements(By.cssSelector("a"));
        for (WebElement element : links) {
            js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "background-color: limegreen; border: 1px dotted solid green;");
        }
        String line = "";
        while ((line = br.readLine()) != null) {
            for (WebElement element : links) {
                if (element.getAttribute("href").contains(line)) {
                    js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "background-color: lightcoral; border: 3px solid red;");
                }
            }
        }
    }
}