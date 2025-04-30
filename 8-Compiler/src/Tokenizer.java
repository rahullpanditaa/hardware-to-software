import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private String sourceCode;
    private static final String keywordsRegex = "(class|constructor|function|method|field" +
                                                "|static|var|int|char|boolean|void|true|false" +
                                                "|null|this|let|do|if|else|while|return)";
    private static final String symbolsRegex = "(\\{|\\}|\\(|\\)|\\[|\\]|\\.|,|;|\\+|-|\\*|/|&|\\||<|>|=|~)";

    public Tokenizer(String jackFile) {
        try {
            this.sourceCode = new String(Files.readAllBytes(Paths.get(jackFile)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getSourceCode() {
        return this.sourceCode;
    }

    private void setSourceCode(String replacement) {
        this.sourceCode = replacement;
    }

    public boolean hasMoreTokens() {
        return !sourceCode.isEmpty();
    }

    // Gets the next token from the input, makes it the current token
    public void advance() {
        removeCommentsAndWhitespace();

    }

    private void removeCommentsAndWhitespace() {
        sourceCode = sourceCode.replaceAll("(// .*|//?\\*\\*? [\\S\\s]+ \\*/)","").strip();

    }


}
