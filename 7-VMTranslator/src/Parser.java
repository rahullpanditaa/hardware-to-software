import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<String> vmCode;

    public Parser(String vmFile) {
        this.vmCode = new ArrayList<>();  // stores the vm code, one list element for a single line of code
        try (BufferedReader reader = new BufferedReader(new FileReader(vmFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                vmCode.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
