import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tokenizer {
    private String sourceCode;
    String currentToken;
    private static List<String> keywords;
    private static List<String> symbols;

    public Tokenizer(String jackFile) {
        try {
            // entire source code as a single string
            this.sourceCode = new String(Files.readAllBytes(Paths.get(jackFile)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean hasMoreToken() {
        return true;
    }

    // initially, there is no current token
    public void advance() {

    }

    private void removeCommentsAndWhitespace() {
        // remove all api block comments and multi-line comments
        sourceCode = sourceCode.replaceAll("/\\*\\*?\\s\\w+\\s+\\*?.+\\s+\\*?.+\\s+\\*?/","");

    }
}
