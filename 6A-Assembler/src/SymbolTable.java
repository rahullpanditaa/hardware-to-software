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

    // will receive the symbol of the current instruction from parser
    public boolean contains(String symbol) {
        // check whether a symbol is in the symbol table
        return symbolTable.containsKey(symbol);
    }

    // @temp - some variable having some address in RAM, starting from 16
    // (label) - label having as its address the line number of next instruction in program
    public void addEntry(String symbol, String value) {
        symbolTable.put(symbol,value);
    }

    // returns the vale/address associated with the symbol
    public int getAddress(String symbol) {
        return Integer.parseInt(symbolTable.get(symbol));
    }
}
