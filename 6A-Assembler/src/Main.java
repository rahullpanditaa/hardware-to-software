import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Parser p = new Parser(args[0]);
        Code c = new Code();
        String hackFileName = args[0].replace(".asm",".hack");
        SymbolTable table = new SymbolTable();
//        start(hackFileName,p,c, table);
        firstPass(table, p);
        secondPass(hackFileName, table, p, c);
    }

    private static void start(String hackFile,Parser parser, Code codeWriter, SymbolTable table) {
        firstPass(table, parser); // adds label declarations to symbol table
        secondPass(hackFile, table, parser, codeWriter);
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
            if (parser.symbol().matches("\\d+")) {
                lineNumber++;
            }
            // current instruction is (label)
            if (parser.instructionType().equals("L_INSTRUCTION")) {
                lineNumber++;
                table.addEntry(parser.symbol(), "" + lineNumber);
            }
        }
    }

    private static void secondPass(String binaryOutput, SymbolTable table, Parser parser, Code codeWriter) {
        // after first pass, have all pre-defined symbols and labels in the tabel
        // ready to parse through and generate output file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(binaryOutput))) {
            int n = 16;   // variable assignment starts from RAM location 16
            while (parser.hasMoreLines()) {
                parser.advance();
                // only have to deal with @symbol and @decimal
                if (parser.instructionType().equals("A_INSTRUCTION")) {
                    // @symbol or @decimal
                    if (parser.symbol().matches("\\d+")) {
                        // @decimal
                        int decimal = Integer.valueOf(parser.symbol());
                        String bin = Integer.toBinaryString(decimal);
                        writer.write("0" + String.format("%15s",bin).replace(' ','0'));
                        writer.write("\n");
                    }
                    // @symbol
                    if (table.contains(parser.symbol())) {
                        // if symbol is a predefined symbol or a label declaration (at beginning)
                        //@SCREEN, @R5
                        // @16384, @5
                        int decimal = table.getAddress(parser.symbol());
                        // have value in decimal eg 16384
                        String bin = Integer.toBinaryString(decimal);
                        writer.write("0" + String.format("%15s",bin).replace(' ','0'));
                        writer.write("\n");
                    }
                    // @variable - will not be in symbol table
                    if (!(table.contains(parser.symbol()))) {
                        table.addEntry(parser.symbol(), "" + n);
                        n++;
                        // eg - @temp now in table -> temp - 16 --> @16
                        int decimal = table.getAddress(parser.symbol());
                        String bin = Integer.toBinaryString(decimal);
                        writer.write("0" + String.format("%15s",bin).replace(' ','0'));
                        writer.write("\n");
                    }
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
