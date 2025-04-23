import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Tokenizer {
    private List<String> sourceCode;

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
}
