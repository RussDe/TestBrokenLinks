import java.io.IOException;
import java.net.URL;
import java.util.*;

//check if links are broken
class TestBrokenLinks {


    public static void main(String[] args) throws IOException, InterruptedException {
        //store pages
        HashSet<URL> setPages;

        //file name for all links
        String fileAll = "all-";
        //file name for bad links
        String fileBad = "bad-";

        //store pages & links
        HashMap<URL, ArrayList<String>> mapLinks;
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
        mapLinks = rl.readLinks(setPages);

        //write data to file
        WriteData wd = new WriteData();
        wd.dataWriter(mapLinks, fileName.replaceFirst("[.][^.]+$", "") + "-" + fileAll);

        //verify links
        CheckLinks chLinks = new CheckLinks();
        wd.dataWriter(chLinks.checkLinks(mapLinks), fileName.replaceFirst("[.][^.]+$", "") + "-" + fileBad);
    }
}