import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;

//create options for command line parser
public class CommandOptions {
    public void commandOptions() {

        //create the Options
        Options options = new Options();
        options.addOption("w", true, "Web page address in format 'http://wwww.apple.com' to check");
        options.addOption("ff", "firefox", false, "Run FireFox to check links");
        options.addOption("ie", "explorer", false, "Run Internet Explorer to check links");
        options.addOption("sf", "safari", false, "Run Safari to check links");
        options.addOption("ch", "chrome", false, "Run Chrome to check links");
    }
}
