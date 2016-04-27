import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//check links if they are valid
class CheckLinks {
    public HashMap<URL, ArrayList<String>> checkLinks(HashMap<URL, ArrayList<String>> mapLinks) {
        System.out.print("Checking links ...");
        HashMap<URL, ArrayList<String>> badLinks = new HashMap<URL, ArrayList<String>>();
        ArrayList<String> arrayBadLinks = new ArrayList<String>();
        for (Map.Entry<URL, ArrayList<String>> entry : mapLinks.entrySet()) {
            for (String link : entry.getValue()) {
                if (verifyLink(link).equals("BAD")) {
                    arrayBadLinks.add(link);
                }
            }
            badLinks.put(entry.getKey(), arrayBadLinks);
        }
        System.out.println(FontColor.ANSI_GREEN + "Done!" + FontColor.ANSI_RESET);
        return badLinks;
    }

    private static String verifyLink(String link) {
        String result = "";
        try {
            URL urlLink = new URL(link);
            HttpURLConnection httpConnect = (HttpURLConnection) urlLink.openConnection();
            httpConnect.setConnectTimeout(3000);
            httpConnect.connect();
            if (httpConnect.getResponseCode() == 200) {
                result = "OK";
            } else result = "BAD";
            httpConnect.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;

    }

}
