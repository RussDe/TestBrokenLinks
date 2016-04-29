import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

//check for a browser
class CheckBrowser {

    public WebDriver checkBrowser(String firstParam) {
        switch (firstParam) {
            case "firefox":
                return new FirefoxDriver();
            case "safari":
                return new SafariDriver();
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/Users/rustem/Projects/IdeaProjects/MarkBrokenLinks/chromedriver");
                return new ChromeDriver();
            default:
                return new FirefoxDriver();
        }
    }
}
