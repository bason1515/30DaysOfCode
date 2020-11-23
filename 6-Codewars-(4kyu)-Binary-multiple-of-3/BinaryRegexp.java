import java.util.regex.Pattern;

public class BinaryRegexp {

    public static Pattern multipleOf3() {
        // Regular expression that matches binary inputs that are multiple of 3
        return Pattern.compile("^0*(110*|10(1|00)*010*)*$");
    }
}