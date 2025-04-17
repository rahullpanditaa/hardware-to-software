
public class Main {
    public static void main(String[] args) {
        Parser p = new Parser("SimpleAdd.vm");
        p.advance();
        System.out.println(p.getCurrentCommand());
        System.out.println(p.hasMoreLines());
        System.out.println(p.commandType());
        System.out.println(p.arg1());
        System.out.println(p.arg2());
        //---
        p.advance();
        System.out.println(p.getCurrentCommand());
        System.out.println(p.hasMoreLines());
        System.out.println(p.commandType());
        System.out.println(p.arg1());
        System.out.println(p.arg2());
        System.out.println();
        p.advance();
        System.out.println(p.getCurrentCommand());
        System.out.println(p.hasMoreLines());
        System.out.println(p.commandType());
        System.out.println(p.arg1());
        System.out.println(p.arg2());
    }
}
