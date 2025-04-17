import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CodeWriter {
    private BufferedWriter writer;
    private static int SP = 256;

    public CodeWriter(String asmFile) {
        try {
            // open an output asm file to write to
            this.writer = new BufferedWriter(new FileWriter(asmFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // only receives ONE COMMAND; responsible for generating assembly for one vm command
    // commandType will come from Parser commandType()
    // segment -> arg1()
    // index -> arg2()
    public void writePushPop(String commandType, String segment, int index) {
        // only push constant i to implement for now
        // arguments -> C_PUSH, constant, i
        // write to file assembly for push constant i
        try {
            writer.write("@" + index);
            writer.write("\n");
            writer.write("D=A");
            writer.write("\n");
            writer.write("@SP");
            writer.write("\n");
            writer.write("A=M");
            writer.write("\n");
            writer.write("M=D");
            writer.write("\n");
            writer.write("@SP");
            writer.write("\n");
            writer.write("M=M+1");
            SP++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
