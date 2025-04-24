import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tokenizer {
    private List<String> sourceCode;
    String currentToken;
    private static List<String> keywords;
    private static List<String> symbols;

    public Tokenizer(String jackFile) {
        this.sourceCode = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(jackFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sourceCode.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        keywords = new ArrayList<>();
        keywords.add("class");
        keywords.add("constructor");
        keywords.add("function");
        keywords.add("method");
        keywords.add("field");
        keywords.add("static");
        keywords.add("var");
        keywords.add("int");
        keywords.add("char");
        keywords.add("boolean");
        keywords.add("void");
        keywords.add("true");
        keywords.add("false");
        keywords.add("null");
        keywords.add("this");
        keywords.add("let");
        keywords.add("do");
        keywords.add("if");
        keywords.add("else");
        keywords.add("while");
        keywords.add("return");

        symbols = new ArrayList<>();
        symbols.add("{");
        symbols.add("}");
        symbols.add("(");
        symbols.add(")");
        symbols.add("[");
        symbols.add("]");
        symbols.add(".");
        symbols.add(",");
        symbols.add(";");
        symbols.add("+");
        symbols.add("-");
        symbols.add("*");
        symbols.add("/");
        symbols.add("&");
        symbols.add("|");
        symbols.add("<");
        symbols.add(">");
        symbols.add("=");
        symbols.add("~");
    }

    public boolean hasMoreToken() {
        return !sourceCode.isEmpty();
    }

    // initially, there is no current token
    public void advance() {

    }

    private void removeCommentsAndWhitespace() {
        // first, remove line comments and whitespace
        Iterator<String> iterator = sourceCode.iterator();
        while (iterator.hasNext()) {
            String line = iterator.next();
            if (line.startsWith("//") || line.isBlank()) {
                iterator.remove();
            }
        }
        // api block comments and multi line comments left


    }
}
