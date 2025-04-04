import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Parser class reads an .asm file and unpacks each instruction into
 * its underlying fields. Writes to a text file that contains the binary translation
 * of the assembly language code.
 */
public class Parser {
    private final String FILE_NAME;
    private List<String> binaryCode;

    public Parser(String asmFile) {
        this.FILE_NAME = asmFile;
        this.binaryCode = new ArrayList<>();
    }

    // the asm file contains lines of strings
    // read file
    public void readFile() {
        try (Scanner reader = new Scanner(Paths.get(FILE_NAME))) {
//            int lineNumber = -1;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.isBlank() || line.startsWith("//")) {  // check whether whitespace or comment
                    continue;
                }
                removeInlineComments(line);
                Code code = new Code(line);
                binaryCode.add(code.convertToBinary());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void removeInlineComments(String line) {
        int inlineCommentStartsAt = line.indexOf("//"); // will return -1 if no inline comment
        if (inlineCommentStartsAt != -1) {
            line = line.substring(0,inlineCommentStartsAt).trim();
        }
    }
}
