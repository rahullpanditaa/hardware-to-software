import java.util.HashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String,String> symbolTable;

    public SymbolTable() {
        // initializing symbol table with pre-defined symbols
        this.symbolTable = new HashMap<>();
        int i = 0;
        while (i < 16) {
            symbolTable.put("R" + i,"" + i);
            i++;
        }
        symbolTable.put("SCREEN","16384");
        symbolTable.put("KBD","24576");
        symbolTable.put("SP","0");
        symbolTable.put("LCL","1");
        symbolTable.put("ARG","2");
        symbolTable.put("THIS","3");
        symbolTable.put("THAT","4");
    }

    public void printSymbols() {
        for (String key : symbolTable.keySet()) {
            System.out.println(key + "-->" + symbolTable.get(key));
        }
    }
}
