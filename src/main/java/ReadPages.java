import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;

//read links from file
class ReadPages {
    //filename
    private final String file;

    public ReadPages(String file) {
        this.file = file;
    }

    public HashSet<URL> readPages() throws IOException {
        System.out.print("\nCreating set of pages ... ");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        HashSet<URL> setPages = new HashSet<URL>();
        String line;
        while ((line = br.readLine()) != null) {
            try {
                URL urlPages = new URL(line);
                setPages.add(urlPages);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

        }
//        for (String item : setPages) {
//            System.out.println(item.toString());
//        }
        System.out.println(FontColor.ANSI_GREEN + "Done!" + FontColor.ANSI_RESET);
        fr.close();
        br.close();
        return setPages;
    }
}