import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The Parser class reads an .asm file and unpacks each instruction into
 * its underlying fields. Writes to a text file that contains the binary translation
 * of the assembly language code.
 */
public class Parser {
    private final String FILE_NAME;

    public Parser(String asmFile) {
        this.FILE_NAME = asmFile;
    }

    // the asm file contains lines of strings
    // read file
    public void readFile() {
        try (Scanner reader = new Scanner(Paths.get(FILE_NAME))) {
            int line_number = -1;
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (!(line.isBlank())) {
                    if (!(line.startsWith("//"))) {
                        removeInlineComments(line);

                    }
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void removeInlineComments(String line) {

    }
}
