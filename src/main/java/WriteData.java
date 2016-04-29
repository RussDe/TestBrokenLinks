import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//write data to file
class WriteData {

    public String dataWriter(ArrayList<String> arrWhole, String fileName) throws IOException {
        //System.out.println("Enter file name: ");
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("MMddyy_HHmmss");
        System.out.printf("File <%s> writing ... ", fileName);
        //String result = "/Users/rustem/Projects/IdeaProjects/MarkBrokenLinks/result_" + df.format(date) + ".txt";
        String result = fileName + df.format(date) + ".txt";
        File file = new File(result);
        FileWriter fw = new FileWriter(file, true);
        for (String item : arrWhole) {
            fw.write(item + "\n");
        }
        System.out.println(FontColor.ANSI_GREEN + "Done!" + FontColor.ANSI_RESET);
        fw.close();
        return result;
    }
}