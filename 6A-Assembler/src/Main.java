public class Main {

    public static void main(String[] args) {
        Parser p = new Parser("MaxL.asm");
//        System.out.println(p.hasMoreLines());
//        System.out.println(p.getCurrentInstruction());
        p.advance();
        for (String line : p.getAssemblyCode()) {
            System.out.println(line);
        }


    }
}
