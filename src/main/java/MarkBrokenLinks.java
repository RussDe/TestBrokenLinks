import java.io.IOException;
import java.net.URL;
import java.util.*;

//check if links are broken
class MarkBrokenLinks {
    static String  BROWSER_DRIVER = null;
    final static String  SAFARI_DRIVER = "SafariDriver";
    final static String  FIREFOX_DRIVER = "FirefoxDriver";
    final static String  CHROME_DRIVER = "ChromeDriver";
    final static String  INTERNET_DRIVER = "InternetExplorerDriver";
    final static String  DEFAULT_DRIVER = SAFARI_DRIVER;

    public static void main(String[] args) throws IOException, InterruptedException {

        //file name for all links
        String fileAll = "all-";
        //file name for bad links
        String fileBad = "bad-";
        //example od bad links file name
        String badLinks = "/Users/rustem/Projects/IdeaProjects/MarkBrokenLinks/bad.txt";
        //store pages & links
        ArrayList<String> arrLinks;
        String fileName = "";

        //read file name
        if (args.length == 0) {
            BROWSER_DRIVER = DEFAULT_DRIVER;
            boolean flag = true;
            Scanner sc = new Scanner(System.in);
            System.out.print("Type file name and hit Enter: ");
            while (flag) {
                fileName = sc.next();
                flag = false;
            }
        } else {


            }

            fileName = args[0];
        }

        //take a page
        ReadPage rp = new ReadPage();
        String pageCreated = rp.readPages(fileName);

        //create set of links
        ReadLinks rl = new ReadLinks();
        arrLinks = rl.readLinks(pageCreated);

        //write data to file
        WriteData wd = new WriteData();
        String allLinksName = wd.dataWriter(arrLinks, fileName.replaceFirst("[.][^.]+$", "") + "-" + fileAll);

        //verify links and write result
        CheckLinks chLinks = new CheckLinks();
        String badLinksName = wd.dataWriter(chLinks.checkLinks(arrLinks), fileName.replaceFirst("[.][^.]+$", "") + "-" + fileBad);

        JS js = new JS();
        js.jsAction(pageCreated, badLinks);

    }
}