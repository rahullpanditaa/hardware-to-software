
public class Main {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer("Main.jack");
//        System.out.println(tokenizer.hasMoreTokens());
        System.out.println(tokenizer.getSourceCode());
        tokenizer.advance(); // will only remove comments and whitespace
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------");
        System.out.println(tokenizer.getSourceCode());
    }
}
