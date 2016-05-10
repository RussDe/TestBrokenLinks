import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

//check links if they are valid
class CheckLinks {
    public ArrayList<String> checkLinks(ArrayList<String> arrLinks) {
        ArrayList<String> newArray = new ArrayList<>();
        System.out.print("Checking links ...");
        for (String link : arrLinks) {
            if (verifyLink(link).equals("BAD")) {
                newArray.add(link);
            }
        }
        System.out.println(FontColor.ANSI_GREEN + "Done!" + FontColor.ANSI_RESET);
        return newArray;
    }

    private static String verifyLink(String link) {
        String result = "";
        try {
            URL urlLink = new URL(link);
            HttpURLConnection httpConnect = (HttpURLConnection) urlLink.openConnection();
            httpConnect.setConnectTimeout(100);
            httpConnect.connect();
            if (httpConnect.getResponseCode() != 404)
                result = "OK";
            else result = "BAD";
            httpConnect.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
