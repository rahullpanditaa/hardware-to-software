import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parser {
    private List<String> assemblyCode;
    private String currentInstruction;
    private int lineNumber = 0;
    private final String A_INSTRUCTION = "A_INSTRUCTION";
    private final String C_INSTRUCTION = "C_INSTRUCTION";

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

    public String getCurrentInstruction() {
         return this.currentInstruction;
    }

    // are there any more lines in the input? - including comments, whitespace (?)
    public boolean hasMoreLines() {
        // each element in list corresponds to one line in the assembly code file
        return !assemblyCode.isEmpty();
    }

    // skips over whitespace and comments
    // reads the next instruction, makes it the current instruction
    // only called if hasMoreLines returns true
    // initially, no current instruction
    public void advance() {
        removeCommentsAndWhiteSpace();
        // removed all comments and whitespace
        // only have to deal with inline comments
        for (String line : assemblyCode) {
            line = line.replaceAll("//.*", "").trim();
        }

        // only have valid lines of assembly code now
        currentInstruction = assemblyCode.get(lineNumber);
        lineNumber++;
        assemblyCode = assemblyCode.subList(lineNumber, assemblyCode.size());
    }

//        if (hasMoreLines()) {
            // if current line is a valid line of code i.e. not a comment or whitespace
//            if (!(assemblyCode.get(lineNumber).startsWith("//") || assemblyCode.get(lineNumber).isBlank())) {
//                currentInstruction = assemblyCode.get(lineNumber).replaceAll("//.*","");
//                lineNumber++;
//                assemblyCode = assemblyCode.subList(lineNumber,assemblyCode.size());
//                return;
//            }
            // if current line is not a valid line of code i.e. either comment or whitespace
//            lineNumber++;
//            assemblyCode = assemblyCode.subList(lineNumber,assemblyCode.size());


    private void removeCommentsAndWhiteSpace() {
        Iterator<String> iter = assemblyCode.iterator();
        while(iter.hasNext()) {
            String line = iter.next();
            if (line.startsWith("//") || line.isBlank()) {
                iter.remove();
            }
        }
    }

    public String instructionType() {
        if (currentInstruction.startsWith("@")) { return A_INSTRUCTION; }
        return C_INSTRUCTION;
    }

    public String dest() {
        if (currentInstruction.contains("=")) {
            return currentInstruction.split("=")[0];
        }
        return "null";
    }

    public String jump() {
        if (currentInstruction.contains(";")) {
            return currentInstruction.split(";")[1];
        }
        return "null";
    }

    public String comp() {
        if (currentInstruction.contains("=") && currentInstruction.contains(";")) {
            // dest=comp;jump
            return currentInstruction.split("=")[1].split(";")[0];
        } else if (currentInstruction.contains("=")) { // dest=comp
            return currentInstruction.split("=")[1];
        } else if (currentInstruction.contains(";")) {
            return currentInstruction.split(";")[0];
        }
        // only comp
        return currentInstruction;
    }
}
