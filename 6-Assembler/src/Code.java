import java.util.HashMap;
import java.util.Map;

public class Code {
    private final Map<String,String> c_instruction_comp;
    private final Map<String,String> c_instruction_dest;
    private final Map<String,String> c_instruction_jump;
    private String currentInstruction;

    public Code(String line) {
        this.currentInstruction = line;

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

        // separate table for dest bits
        this.c_instruction_dest = new HashMap<>();
        c_instruction_dest.put("null","000");
        c_instruction_dest.put("M","001");
        c_instruction_dest.put("D","010");
        c_instruction_dest.put("MD","011");
        c_instruction_dest.put("A","100");
        c_instruction_dest.put("AM","101");
        c_instruction_dest.put("AD","110");
        c_instruction_dest.put("AMD","111");

        this.c_instruction_jump = new HashMap<>();
        c_instruction_jump.put("null","000");
        c_instruction_jump.put("JGT","001");
        c_instruction_jump.put("JEQ","010");
        c_instruction_jump.put("JGE","011");
        c_instruction_jump.put("JLT","100");
        c_instruction_jump.put("JNE","101");
        c_instruction_jump.put("JLE","110");
        c_instruction_jump.put("JMP","111");
    }

    public String convertToBinary() {
        if (currentInstruction.startsWith("@")) {
            return AInstructionToBinary();
        }
        return CInstructionToBinary();
    }

    private String AInstructionToBinary() {
        int value = Integer.valueOf(currentInstruction.substring(1));
        String AInBinary = Integer.toBinaryString(value);
        if (AInBinary.length() > 15) {
            AInBinary = AInBinary.substring(AInBinary.length()-15);
        }
        return "";
    }

    private String CInstructionToBinary() {
        // dest=comp;jump -> dest and jump are optional fields
        if (currentInstruction.contains("=") && currentInstruction.contains(";")) {
            // both dest and jump fields also present
            String[] arr = currentInstruction.split("=");
            String[] compAndJump = arr[1].split(";");
            String destBits = c_instruction_dest.get(arr[0]);
            String compBits = c_instruction_comp.get(compAndJump[0]);
            String jumpBits = c_instruction_jump.get(compAndJump[1]);
            return "111" + destBits + compBits + jumpBits;
        }
        // only dest and comp; jump is null
        if (currentInstruction.contains("=")) {
            String[] destAndComp = currentInstruction.split("=");
            return "111" + c_instruction_dest.get(destAndComp[0]) + c_instruction_comp.get(destAndComp[1]) + c_instruction_jump.get("null");
        }
        // dest null; comp and jump
        if (currentInstruction.contains(";")) {
            String[] compAndJump = currentInstruction.split(";");
            return "111" + c_instruction_dest.get("null") + c_instruction_comp.get(compAndJump[0]) + c_instruction_jump.get(compAndJump[1]);
        }

        // only comp field present; rest are null
        return "111" + c_instruction_dest.get("null") + c_instruction_comp.get(currentInstruction) + c_instruction_jump.get("null");
    }


}
