package view;

import java.util.Locale;
import java.util.ResourceBundle;

public class View {
    public static final String MESSAGES_BUNDLE_NAME = "messages";
    public static ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    new Locale("ua"));                // Ukrainian
                    //new Locale("en"));        // English

    public static final String AUTHORS = "authors";

    public void printError(String err) {
        System.err.println(err);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
