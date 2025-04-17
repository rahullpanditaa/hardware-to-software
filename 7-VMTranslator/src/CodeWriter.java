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

    // command received from arg1()
    public void writeArithmetic(String command) {
        try {
            if (command.equals("add")) {
                writer.write("@SP");
                writer.write("\n");
                writer.write("A=M");
                writer.write("\n");
                writer.write("A=A-1");
                writer.write("\n");
                writer.write("D=M");
                writer.write("\n");
                writer.write("A=A-1");
                writer.write("\n");
                writer.write("M=D+M"); //for sub, this will change to M=M-D
                writer.write("\n");
//                writer.write("D=A+1");
//                writer.write("\n");
                writer.write("@SP");
                writer.write("\n");
                writer.write("M=M-1");
                writer.write("\n");
                SP--;
            }
            if (command.equals("sub")) {
                writer.write("@SP");
                writer.write("\n");
                writer.write("A=M");
                writer.write("\n");
                writer.write("A=A-1");
                writer.write("\n");
                writer.write("D=M");
                writer.write("\n");
                writer.write("A=A-1");
                writer.write("\n");
                writer.write("M=M-D"); //for sub, this will change to M=M-D
                writer.write("\n");
//                writer.write("D=A+1");
//                writer.write("\n");
                writer.write("@SP");
                writer.write("\n");
                writer.write("M=M-1");
                writer.write("\n");
                SP--;
            }
            if (command.equals("neg")) {
                writer.write("@SP");
                writer.write("\n");
                writer.write("A=M-1");
                writer.write("\n");
                writer.write("M=-M");
                writer.write("\n");
                // SP does not change
            }
            if (command.equals("eq")) {
                writer.write("@SP");
                writer.write("\n");
                writer.write("A=M-1");
                writer.write("\n");
                writer.write("D=M");
                writer.write("\n");
                writer.write("A=A-1");
                writer.write("\n");
                writer.write("M=M-D");
                writer.write("\n");
                writer.write("@FALSE");
                writer.write("\n");
                writer.write("M;JNE");
                writer.write("\n");
                writer.write("M=-1");
                writer.write("\n");
                writer.write("(FALSE)");
                writer.write("\n");
                writer.write("M=0");
                writer.write("\n");
                writer.write("@SP");
                writer.write("\n");
                writer.write("M=M-1");
                writer.write("\n");
                SP--;
            }
            if (command.equals("gt")) {
                writer.write("@SP");
                writer.write("\n");
                writer.write("M=M-1");   // implementing SP-- earlier in assembly code; seems like it will work
                writer.write("\n");
                writer.write("A=M");
                writer.write("\n");
                writer.write("D=M");
                writer.write("\n");
                writer.write("A=A-1");
                writer.write("\n");
                writer.write("M=M-D");
                writer.write("\n");
                writer.write("@TRUE");
                writer.write("\n");
                writer.write("M;JGT");
                writer.write("\n");
                writer.write("M=0");
                writer.write("\n");
                writer.write("(TRUE)");
                writer.write("\n");
                writer.write("M=-1");
                writer.write("\n");
            }
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
            writer.write("\n");
            SP++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        try {
            if (writer != null) {
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
