import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parser {
    private List<String> assemblyCode;
    private String currentInstruction;
    private final String A_INSTRUCTION = "A_INSTRUCTION";
    private final String C_INSTRUCTION = "C_INSTRUCTION";
    private final String L_INSTRUCTION = "L_INSTRUCTION";

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
        // only have a list where each element corresponds to a valid line of assembly code
        if (hasMoreLines()) {
            currentInstruction = assemblyCode.get(0);
            assemblyCode.remove(0);
        }
    }

    private void removeCommentsAndWhiteSpace() {
        Iterator<String> iter = assemblyCode.iterator();
        while(iter.hasNext()) {
            String line = iter.next();
            if (line.startsWith("//") || line.isBlank()) {
                iter.remove();
            }
        }
        for (String line : assemblyCode) {
            line = line.replaceAll("//.*", "").trim();
        }
    }

    public String instructionType() {
        if (currentInstruction.startsWith("@")) { return A_INSTRUCTION; }
        if (currentInstruction.startsWith("(")) { return L_INSTRUCTION; }
        return C_INSTRUCTION;
    }

    public String symbol() {
        if (instructionType().equals(A_INSTRUCTION)) {      // @xxx, xxx is either a decimal or symbol
            return currentInstruction.substring(1);
        }
        // (xxx),  a label declaration
        return currentInstruction.substring(1,currentInstruction.length()-1);
    }

    public String dest() {
        if (!(instructionType().equals(C_INSTRUCTION))) {
            throw new IllegalStateException("current instruction is not a C-Instruction");
        }
        if (currentInstruction.contains("=")) {
            return currentInstruction.split("=")[0];
        }
        return "null";
    }

    public String jump() {
        if (!(instructionType().equals(C_INSTRUCTION))) {
            throw new IllegalStateException("current instruction is not a C-Instruction");
        }
        if (currentInstruction.contains(";")) {
            return currentInstruction.split(";")[1];
        }
        return "null";
    }

    public String comp() {
        if (!(instructionType().equals(C_INSTRUCTION))) {
            throw new IllegalStateException("current instruction is not a C-Instruction");
        }
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
