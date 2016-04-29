import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

//create options for command line parser
public class CommandOptions extends Options {

    public Options commandOptions() {
        //create the Options
        Options options = new Options();
        options.addOption(Option.builder("w")
                .argName("webpage")
                .hasArg()
                .desc("Web page address in format 'http://wwww.apple.com' to check")
                .build());
        options.addOption(Option.builder("b")
                .desc("Set browser to run checking links")
                .build());
        options.addOption("h", false, "Help");
        return options;
    }
}
