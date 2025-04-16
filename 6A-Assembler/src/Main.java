import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
//        Parser p = new Parser(args[0]);
//        Code c = new Code();
//        String hackFileName = args[0].replace(".asm",".hack");
//        start(hackFileName,p,c);
        SymbolTable table = new SymbolTable();
        table.printSymbols();
    }

    private static void start(String hackFile,Parser parser, Code codeWriter) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(hackFile))) {
            while (parser.hasMoreLines()) {
                parser.advance(); // get the current instruction
                if (parser.instructionType().equals("A_INSTRUCTION")) {
                    int decimal = Integer.valueOf(parser.getCurrentInstruction().substring(1));
                    String bin = Integer.toBinaryString(decimal);
                    writer.write("0" + String.format("%15s",bin).replace(' ','0'));
                    writer.write("\n");
                }
                if (parser.instructionType().equals("C_INSTRUCTION")) {
                    String cToBinary = "111" + codeWriter.comp(parser.comp()) +codeWriter.dest(parser.dest()) + codeWriter.jump(parser.jump());
                    writer.write(cToBinary);
                    writer.write("\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
