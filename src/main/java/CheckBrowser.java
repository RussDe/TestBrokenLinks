//check for a browser
public class CheckBrowser {
    public String checkBrowser(String firstParam) {
        switch (firstParam) {
            case "-firefox":
                return MarkBrokenLinks.FIREFOX_DRIVER;
            case "-safari":
                return MarkBrokenLinks.SAFARI_DRIVER;
            case "-chrome":
                return MarkBrokenLinks.CHROME_DRIVER;
            case "-explorer":
                return MarkBrokenLinks.INTERNET_DRIVER;
            default:
                return MarkBrokenLinks.DEFAULT_DRIVER;
        }
    }
}
