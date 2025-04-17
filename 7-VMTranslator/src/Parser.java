import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Parser {
    private List<String> vmCode;
    private String currentCommand;
    private final List<String> arithmeticCommands;
    private static final String C_ARITHMETIC = "C_ARITHMETIC";
    private static final String C_PUSH = "C_PUSH";
    private static final String C_POP = "C_POP";

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
        this.arithmeticCommands = new ArrayList<>();
        arithmeticCommands.add("add");
        arithmeticCommands.add("sub");
        arithmeticCommands.add("neg");
        arithmeticCommands.add("eq");
        arithmeticCommands.add("gt");
        arithmeticCommands.add("lt");
        arithmeticCommands.add("and");
        arithmeticCommands.add("or");
        arithmeticCommands.add("not");
    }

    public String getCurrentCommand() {
        return currentCommand;
    }

    public boolean hasMoreLines() {
        return !vmCode.isEmpty();
    }

    // get the next vm command, make it the current command
    public void advance() {
        removeCommentsAndWhiteSpace();
        // Now, only valid lines of vm code are present as elements of the list
        if (hasMoreLines()) {
            currentCommand = vmCode.get(0);
            vmCode.remove(0); // once next instruction stored as current instruction, remove it from vm code; don't need it

        }
    }

    // private method to remove all comments, inline comments and whitespace from code
    // i.e. delete elements from list that are whitespace or comments
    // remove inline comments from valid lines of code
    private void removeCommentsAndWhiteSpace() {
        Iterator<String> iterator = vmCode.iterator();
        while (iterator.hasNext()) {
            String line = iterator.next();
            if (line.startsWith("//") || line.isBlank()) {
                iterator.remove();
            }
        }
        // remove inline comments
        for (String line : vmCode) {
            line = line.replaceAll("//.*","").trim();
        }
    }

    public String commandType() {
        // Version 1 only has push constant i and arithmetic and logical commands
        if (arithmeticCommands.contains(currentCommand)) {
            return C_ARITHMETIC;
        }
        if (currentCommand.startsWith("push")) { return C_PUSH; }
        return C_POP;
    }



}
