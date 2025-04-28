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
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public boolean hasMoreTokens() {
        return !sourceCode.isEmpty();
    }

    // initially, there is no current token
    public void advance() {
//        removeCommentsAndWhitespace();
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
