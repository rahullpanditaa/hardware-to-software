import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Pattern pattern = Pattern.compile("\\w"); // the pattern to check for and match against i.e. the regex
        Matcher matcher = pattern.matcher("hello"); // the input string (eg jack source code)

        System.out.println(matcher.find());
    }
}
