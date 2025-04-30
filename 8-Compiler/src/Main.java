import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Tokenizer tokenizer = new Tokenizer("Main.jack");
//        System.out.println(tokenizer.getSourceCode());
        tokenizer.advance();
        System.out.println(tokenizer.getSourceCode());


//        Pattern pattern = Pattern.compile("^(\\d+) divided by (\\d+)$");
//        Matcher matcher = pattern.matcher("100 divided by 25");

        // 100 divided by 2 --> 100 / 2
//        if (matcher.find()) {
//            String simplified = matcher.replaceFirst("$1/$2");  // extracting multiple groups -> $groupNumber
//            System.out.println(simplified);
//            int result = Integer.valueOf(matcher.group(1)) / Integer.valueOf(matcher.group(2));
//            System.out.println(result);
//        }

//        String cardNumber = "9876-5432-1234";
//         XXXX-XXXX-1234

//        Pattern pattern = Pattern.compile("\\d{4}-\\d{4}-");
//        Matcher matcher = pattern.matcher(cardNumber);

//        String privateCardNumber = matcher.replaceAll("XXXX-XXXX-");
//        System.out.println(privateCardNumber);

//        Pattern pattern = Pattern.compile("^agent \\d{3,}$"); // the pattern to check for and match against i.e. the regex
//        Matcher matcher = pattern.matcher("agent 007"); // the input string (eg jack source code)

//        Pattern methodNamePattern = Pattern.compile("(\\w+)\\(\\)");
//        Matcher matcher = methodNamePattern.matcher("methodName()");

//        if (matcher.find()) {
//            System.out.println(matcher.group(1));
//        }



    }
}
