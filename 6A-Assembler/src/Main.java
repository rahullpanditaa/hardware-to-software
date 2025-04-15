public class Main {

    public static void main(String[] args) {
        Parser p = new Parser("MaxL.asm");
        System.out.println(p.hasMoreLines());
        System.out.println(p.getCurrentInstruction());
        System.out.println(p.hasMoreLines());
        System.out.println(p.getCurrentInstruction());

    }
}
