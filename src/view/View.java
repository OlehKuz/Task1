package view;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
public class View {

    // Resource Bundle Installation's
    static String MESSAGES_BUNDLE_NAME = "messages";
    //private static Locale locale = new Locale("ua");
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    "messages",
                    new Locale("ua", "UA"));  // Ukrainian
                    //new Locale("en"));        // English

    //Utilities methods
    /**
     *
     * @param message
     */
    /*public void printMessage(String message){
        System.out.println(message);
    }*/
    public void printMessage(String message) {
        Optional<String> mess = Optional.ofNullable(message);
        mess.ifPresent(x->System.out.println(this.unwrapBundled(x)));
    }
    public String unwrapBundled(String message){ //TODO very wrong!
        for (String key : bundle.keySet()){
            if(message.contains(key)){
                message = message.replaceAll(key,bundle.getString(key));
            }
 }
        return message;
  }
}