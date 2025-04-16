import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Parser p = new Parser(args[0]);
        Code c = new Code();
        String hackFileName = args[0].replace(".asm",".hack");
        SymbolTable table = new SymbolTable();
        start(hackFileName,p,c);
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

    // not writing anything to output yet
    // adding (label) and address to symbol table
    private static void firstPass(SymbolTable table, Parser parser) {
        // argument symbol table already has all predefined symbols
        // only need to parse through and add label declarations to table
        int lineNumber = 0;
        while (parser.hasMoreLines()) {
            parser.advance();   // get the current instruction
            // check if current instruction is @decimal, if yes then skip
            if (parser.getCurrentInstruction().substring(1).matches("\\d+")) {
                lineNumber++;
            }
            // current instruction is (label)
            if (parser.instructionType().equals("L_INSTRUCTION")) {
                lineNumber++;
                table.addEntry(parser.symbol(), "" + lineNumber);
            }
        }
    }

    private static void secondPass(SymbolTable table, Parser parser, Code codeWriter) {
        // after first pass, have all pre-defined symbols and labels in the tabel
        // ready to parse through and generate output file
        int n = 16;     
    }
}
