import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private List<String> assemblyCode;
    private String currentInstruction;
    private final int lineNumber = 0;
    private final String A_INSTRUCTION = "A";
    private final String C_INSTRUCTION = "C";

    public Parser(String asmFile) {
        // open input file, store contents in list to make it available for operations from other methods
        this.assemblyCode = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(asmFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                assemblyCode.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean hasMoreLines() {
        // Dealing with an ArrayList now
        // check whether file aka list was empty
        if (this.assemblyCode.isEmpty()) {
            return false;
        }

        // 1 or more lines in asm file --> 1 or more elements in list
        for (int i = 0; i < assemblyCode.size(); i++) {
            String currentLine = assemblyCode.get(i);
            if (!(currentLine.startsWith("//") || currentLine.isBlank())) {  // not a comment or whitespace
                advance(currentLine);
                return true;
            }
        }
        return false;
    }

    // returns the current instruction to be converted to binary
    public String advance(String instruction) {
        this.currentInstruction = instruction;
        return currentInstruction;
    }


}
