import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//write data to file
class WriteData {

    public void dataWriter(HashMap<URL, ArrayList<String>> mapWhole, String fileName) throws IOException {
        //System.out.println("Enter file name: ");
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("MMddyy_HHmmss");
        System.out.printf("File <%s> writing ... ",fileName);
        //String result = "/Users/rustem/Projects/IdeaProjects/TestBrokenLinks/result_" + df.format(date) + ".txt";
        String result = fileName + df.format(date) + ".txt";

        File file = new File(result);
        FileWriter fw = new FileWriter(file, true);
        //using keySet
//        for (URL key: mapWhole.keySet()) {
//            fw.write("********************************" + "\n");
//            fw.write(key + " : " + "\n");
//            fw.write("********************************" + "\n");
//            for (String item : mapWhole.get(key)) {
//                fw.write(item + "\n");
//            }
//        }
        //using sentrySet
        for (Map.Entry<URL, ArrayList<String>> entry : mapWhole.entrySet()) {
            URL page = entry.getKey();
            fw.write("********************************" + "\n");
            fw.write(page.toString() + " : " + "\n");
            fw.write("********************************" + "\n");
            for (String item : entry.getValue()) {
                fw.write(item + "\n");
            }
        }
        System.out.println(FontColor.ANSI_GREEN + "Done!" + FontColor.ANSI_RESET);
        fw.close();
    }
}