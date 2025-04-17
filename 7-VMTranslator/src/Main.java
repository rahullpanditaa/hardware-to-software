
public class Main {
    public static void main(String[] args) {
        Parser p = new Parser("SimpleAdd.vm");
        System.out.println(p.getCurrentCommand());
        for (String line : p.getVmCode()) {
            System.out.println(line);
        }
    }
}
