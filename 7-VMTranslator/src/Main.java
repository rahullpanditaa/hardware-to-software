
public class Main {
    public static void main(String[] args) {
        String vmFile = args[0];
        String asmFile = vmFile.replace(".vm", ".asm");
        Parser p = new Parser(vmFile);
        CodeWriter writer = new CodeWriter(asmFile);
        start(p, writer);
    }

    public static void start(Parser parser, CodeWriter code) {
        while (parser.hasMoreLines()) {
            parser.advance(); // only have valid lines of code to deal with; gets the next instruction and make it current command
            if (parser.commandType().equals("C_ARITHMETIC")) {
                code.writeArithmetic(parser.arg1());
            }
            if (parser.commandType().equals("C_PUSH")) {
                code.writePushPop(parser.commandType(), parser.arg1(), parser.arg2());
            }
        }
        code.close();
    }
}
