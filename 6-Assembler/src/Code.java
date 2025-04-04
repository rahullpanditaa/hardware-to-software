import java.util.HashMap;
import java.util.Map;

public class Code {
    private final Map<String,String> c_instruction_comp;

    public Code() {
        this.c_instruction_comp = new HashMap<>();
        c_instruction_comp.put("0","0101010");
        c_instruction_comp.put("1","0111111");
        c_instruction_comp.put("-1","0111010");
        c_instruction_comp.put("D","0001100");
        c_instruction_comp.put("A","0110000");
        c_instruction_comp.put("!D","0001101");
        c_instruction_comp.put("!A","0110001");
        c_instruction_comp.put("-D","0001111");
        c_instruction_comp.put("-A","0110011");
        c_instruction_comp.put("D+1","0011111");
        c_instruction_comp.put("A+1","0110111");
        c_instruction_comp.put("D-1","0001110");
        c_instruction_comp.put("A-1","0110010");
        c_instruction_comp.put("D+A","0000010");
        c_instruction_comp.put("D-A","0010011");
        c_instruction_comp.put("A-D","0000111");
        c_instruction_comp.put("D&A","0000000");
        c_instruction_comp.put("D|A","0010101");
        c_instruction_comp.put("M","1110000");
        c_instruction_comp.put("!M","!110001");
        c_instruction_comp.put("-M","1110011");
        c_instruction_comp.put("M+1","1110111");
        c_instruction_comp.put("M-1","1110010");
        c_instruction_comp.put("D+M","1000010");
        c_instruction_comp.put("D-M","1010011");
        c_instruction_comp.put("M-D","1000111");
        c_instruction_comp.put("D&M","1000000");
        c_instruction_comp.put("D|M","1010101");
    }
}
