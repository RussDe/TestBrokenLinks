import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

//check for a browser
public class CheckBrowser {
    public WebDriver checkBrowser(String firstParam) {
        switch (firstParam) {
            case "firefox":
                return new FirefoxDriver();
            case "safari":
                return new SafariDriver();
            case "chrome":
                return new ChromeDriver();
//            case "explorer":
//                return ;
            default:
                return new FirefoxDriver();
        }
    }
}
