
public class Main {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer("Main.jack");
//        System.out.println(tokenizer.hasMoreTokens());
//        System.out.println(tokenizer.getCurrentToken());
//        System.out.println(tokenizer.getSourceCode());
//        System.out.println();
//        System.out.println();
//        System.out.println("Sanitized string:");
        tokenizer.advance();
        System.out.println(tokenizer.getSourceCode());

    }
}
