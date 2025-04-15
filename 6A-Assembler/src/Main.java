public class Main {

    public static void main(String[] args) {
        Parser p = new Parser("MaxL.asm");
        System.out.println(p.getCurrentInstruction());
        p.advance();
        System.out.println(p.getCurrentInstruction());
        System.out.println(p.instructionType());
//        System.out.println(p.dest());
        p.advance();
        System.out.println(p.getCurrentInstruction());
        System.out.println(p.instructionType());
        System.out.println(p.dest());
        System.out.println(p.comp());
        System.out.println(p.jump());




    }
}
