import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tokenizer {
    private List<String> sourceCode;
    String currentToken;

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


    }
}
