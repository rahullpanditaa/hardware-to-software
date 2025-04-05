import java.io.FileWriter;
import java.io.IOException;

public class CodeWriter {
    private final String asmFile;
    private FileWriter writer;
    private int SP = 256;

    public CodeWriter(String asmFile) {
        this.asmFile = asmFile;
        try {
            this.writer = new FileWriter(asmFile);  // opened a file for generating output
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeArithmetic(String command) {
        if (command.equals("add")) {
            


        }
    }

    public void writePushPop(String command, String segment, int index) {
        // only one command for now; push constant i

        try {
//            FileWriter writer = new FileWriter(asmFile);
            writer.write("@" + index);
            writer.write("\n");
            writer.write("D=A\n");
            writer.write("@SP\n");
            writer.write("A=M\n");
            writer.write("M=D\n");
            writer.write("@SP\n");
            writer.write("M=M+1");
            SP++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
