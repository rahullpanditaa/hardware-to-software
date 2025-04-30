import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tokenizer {
    private String sourceCode;

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


}
