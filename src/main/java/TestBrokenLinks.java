import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

//check if links are broken
public class TestBrokenLinks {


    public static void main(String[] args) throws IOException {
        //store pages
        HashSet<URL> setPages = new HashSet<URL>();

        //store pages & links
        HashMap<URL, String> setLinks = new HashMap<URL, String>();
        String fileName = "";

        //read file name
        if (args.length == 0) {
            boolean flag = true;
            Scanner sc = new Scanner(System.in);
            System.out.print("Type file name and hit Enter: ");
            while (flag) {
                fileName = sc.next();
                flag = false;
            }
        } else fileName = args[0];
        ReadPages rp = new ReadPages(fileName);

        //create set of pages as URL's
        setPages = rp.readPages();

        //create set of links
        ReadLinks rl = new ReadLinks();
        setLinks = rl.readLinks(setPages);
        for (Map.Entry<URL, String> entry : setLinks.entrySet()) {
            URL page = entry.getKey();
            String link = entry.getValue();
        }

        //write data to file
        WriteData wd = new WriteData();
        wd.dataWriter(setLinks);
    }
}