import java.util.HashMap;
import java.util.Map;

// dest=comp;jump
public class Code {
    private final Map<String,String> compBinary;
//    private final Map<String,String> destBinary;
//    private final Map<String,String> jumpBinary;

    public Code() {
        this.compBinary = new HashMap<>();
        compBinary.put("0","0101010");
        compBinary.put("1","0111111");
        compBinary.put("-1","0111010");
        compBinary.put("D","0001100");
        compBinary.put("A","0110000");
        compBinary.put("!D","0001101");
        compBinary.put("!A","0110001");
        compBinary.put("-D","0001111");
        compBinary.put("-A","0110011");
        compBinary.put("D+1","0011111");
        compBinary.put("A+1","0110111");
        compBinary.put("D-1","0001110");
        compBinary.put("A-1","0110010");
        compBinary.put("D+A","0000010");
        compBinary.put("D-A","0010011");
        compBinary.put("A-D","0000111");
        compBinary.put("D&A","0000000");
        compBinary.put("D|A","0010101");
        compBinary.put("M","1110000");
        compBinary.put("!M","1110001");
        compBinary.put("-M","1110011");
        compBinary.put("M+1","1110111");
        compBinary.put("M-1","1110010");
        compBinary.put("D+M","1000010");
        compBinary.put("D-M","1010011");
        compBinary.put("M-D","1000111");
        compBinary.put("D&M","1000000");
        compBinary.put("D|M","1010101");

    }
}
