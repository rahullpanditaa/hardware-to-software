import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        Pattern pattern = Pattern.compile("^agent \\d{3,}$"); // the pattern to check for and match against i.e. the regex
//        Matcher matcher = pattern.matcher("agent 007"); // the input string (eg jack source code)

        Pattern methodNamePattern = Pattern.compile("(\\w+)\\(\\)");
        Matcher matcher = methodNamePattern.matcher("methodName()");

        if (matcher.find()) {
            System.out.println(matcher.group(1));
        }


    }
}
