import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer("Main.jack");
        start(tokenizer, "Main.xml");

    }

    // DEBUG THIS!!
    private static void start(Tokenizer tokenizer, String jackFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(jackFile))) {
            writer.write("<tokens>");
            writer.write("\n");
            while (tokenizer.hasMoreTokens()) {
                tokenizer.advance();
                if (tokenizer.tokenType().equals("KEYWORD")) {
                    writer.write("<keyword>" + tokenizer.keyword() + "</keyword>");
                    writer.write("\n");
                }
                if (tokenizer.tokenType().equals("SYMBOL")) {
                    writer.write("<symbol>" + tokenizer.symbol() + "</symbol>");
                    writer.write("\n");
                }
                if (tokenizer.tokenType().equals("IDENTIFIER")) {
                    writer.write("<identifier>" + tokenizer.identifier() + "</identifier>");
                    writer.write("\n");
                }
                if (tokenizer.tokenType().equals("INT_CONST")) {
                    writer.write("<integerConstant>" + tokenizer.intVal() + "</integerConstant>");
                    writer.write("\n");
                }
                if (tokenizer.tokenType().equals("STR_CONST")) {
                    writer.write("<stringConstant>" + tokenizer.stringVal() + "</stringConstant>");
                }

            }
            writer.write("<tokens>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
