
public class Main {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer("Main.jack");
        System.out.println(tokenizer.hasMoreTokens());
        System.out.println(tokenizer.getCurrentToken());
        System.out.println(tokenizer.getSourceCode());

    }
}
