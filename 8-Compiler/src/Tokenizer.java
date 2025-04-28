import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
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

    public String getSourceCode() {
        return sourceCode;
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public boolean hasMoreTokens() {
        return !sourceCode.isEmpty();
    }

    // initially, there is no current token
    public void advance() {
        removeCommentsAndWhitespace(); // will remove all comments
        // Now, only valid tokens and whitespace left
    }

    private void removeCommentsAndWhitespace() {
        // remove api block comments and multiline comments
        sourceCode = sourceCode.replaceAll("\\/\\*[\\s\\S]*?\\*\\/","");

        // remove all single line and inline comments
        sourceCode = sourceCode.replaceAll("//.*","");
    }

















//    private void removeCommentsAndWhitespace() {
//        // remove all api block comments and multi-line comments
//        sourceCode = sourceCode.replaceAll("/\\*\\*?\\s\\w+\\s+\\*?.+\\s+\\*?.+\\s+\\*?/","");
//        // ->// comments
//        String[] lines = sourceCode.split("\n");
//        for (String line : lines) {
//            line = line.replaceAll("[^\"^\\w]//\\s*\\w*[^\"]","");
//        }
//        // only inline comments and whitespace lines and lines starting with a comment left
//        List<String> linesToArrayList = new ArrayList<>(Arrays.asList(lines));
//        Iterator<String> iterator = linesToArrayList.iterator();
//        while (iterator.hasNext()) {
//            String lineOfCode = iterator.next();
//            if (lineOfCode.startsWith("//") || lineOfCode.isBlank()) {
//                iterator.remove();
//            }
//        }
//        // only inline comments left
////        for (String line : linesToArrayList) {
////            line = line.replaceAll("//.*","");
////        }
//        sourceCode = String.join("\n",linesToArrayList);
//    }
}
