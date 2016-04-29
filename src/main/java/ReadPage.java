import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReadPage {
    String page = "";
    public String readPages(String page) throws IOException {
        System.out.print("\nCreating a page ... ");
        FileReader fr = new FileReader(page);
        BufferedReader br = new BufferedReader(fr);
                page = br.readLine();
        System.out.println(FontColor.ANSI_GREEN + "Done!" + FontColor.ANSI_RESET);
        fr.close();
        br.close();
        return page;
    }
}