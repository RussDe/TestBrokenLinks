import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//write data to file
public class WriteData {

    public void dataWriter(HashMap<URL, String> mapWhole) throws IOException {
        //System.out.println("Enter file name: ");
        String path;
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("MMddyy_HH-mm-ss");
        System.out.print("File writing ... ");
        //String result = "/Users/rustem/Projects/IdeaProjects/TestBrokenLinks/result_" + df.format(date) + ".txt";
        String result = "result_" + df.format(date) + ".txt";

        File file = new File(result);
        FileWriter fw = new FileWriter(file, true);
        for (Map.Entry<URL, String> entry : mapWhole.entrySet()) {
            URL page = entry.getKey();
            String link = entry.getValue();
            fw.write(page.toString() + " : " + link +"\n");
        }
        System.out.println(FontColor.ANSI_GREEN + "Done!" + FontColor.ANSI_RESET);
        fw.close();
    }
}
