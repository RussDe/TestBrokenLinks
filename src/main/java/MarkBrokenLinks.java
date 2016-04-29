import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.net.URL;
import java.util.*;

//check if links are broken
class MarkBrokenLinks {
    static String BROWSER_DRIVER = null;
    final static String SAFARI_DRIVER = "SafariDriver";
    final static String FIREFOX_DRIVER = "FirefoxDriver";
    final static String CHROME_DRIVER = "ChromeDriver";
    final static String INTERNET_DRIVER = "InternetExplorerDriver";
    final static String DEFAULT_DRIVER = SAFARI_DRIVER;

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
        //create a var for a page
        String pageCreated = "";

        WebDriver driver = null;
        //WebDriver driver = new FirefoxDriver();
        CheckBrowser chBr = new CheckBrowser();


        //read file name
        if (args.length == 1) {
            if (ValidURL.validURL(args[0])) {
                pageCreated = args[0];
            } else {
                boolean flag = true;
                Scanner sc = new Scanner(System.in);
                System.out.print("Please provide a page in <http://www.apple.com> format and hit Enter: ");
                while (flag) {
                    fileName = sc.next();
                    flag = false;
                }
                pageCreated = fileName;
            }
            driver = chBr.checkBrowser("firefox");
        } else if (args.length == 2) {
            if (ValidURL.validURL(args[0]) && args[1].startsWith("-")) {
                pageCreated = args[0];
                driver = chBr.checkBrowser(args[1].substring(1));
            }
        } else {
            System.out.println("Bad parameters! The program stops! ");
            System.exit(0);
        }

        //fileName = args[0];

//        //reading args from command line
//        CommandOptions opt = new CommandOptions();
//
//        CommandLine line = null;
//        //parsing args
//        CommandLineParser parser = new DefaultParser();
//        try {
//            line = parser.parse(opt.commandOptions(), args);
//        } catch (org.apache.commons.cli.ParseException e) {
//            e.printStackTrace();
//        }

//        //check for a page
//        if (line.hasOption("w")) {
//            pageCreated = line.getOptionValue("w");
//        } else {
//            pageCreated = "http://www.apple.com/mac/";
//        }
//
//        //check for a browser
//        if (line.hasOption("b")) {
//            CheckBrowser chBr = new CheckBrowser();
//            driver = chBr.checkBrowser(line.getOptionValue("b"));
//        }
//
//        //check for a help
//        if (line.hasOption("h")) {
//            HelpFormatter help = new HelpFormatter();
//            help.printHelp("Options: ", opt);
//        }

//        //take a page
//        ReadPage rp = new ReadPage();
//        String pageCreated = rp.readPages(fileName);

        //create set of links
        ReadLinks rl = new ReadLinks();
        arrLinks = rl.readLinks(pageCreated);

        //write data to file
        WriteData wd = new WriteData();
        String allLinksName = wd.dataWriter(arrLinks, fileName.replaceFirst("^(http://www\\.|http://|www\\.)","") + "-" + fileAll);

        //verify links and write result
        CheckLinks chLinks = new CheckLinks();
        //String badLinksName = wd.dataWriter(chLinks.checkLinks(arrLinks), fileName.replaceFirst("[.][^.]+$", "") + "-" + fileBad);

        if(driver!=null) {
            JS js = new JS();
            js.jsAction(pageCreated, badLinks, driver);
        }
    }
}