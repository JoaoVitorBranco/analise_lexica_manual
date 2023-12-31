
import lexer.tags.ConstHex;

public class TestConstHex{
  public static void main(String[] args) {
    String hex_1 = "0xAbcdefa";
    String hex_2 = "0X10A";
    String invalid_hex_1 = "0x1G";
    String invalid_hex_2 = "01G";
    String invalid_hex_3 = "0X";

    ConstHex const_hex_1 = new ConstHex(hex_1, 10, 1);

    System.out.println("Hex 1: " + const_hex_1.getHex());
    System.out.println("Line 1: " + const_hex_1.getLine());

    System.out.println(ConstHex.isConstHex(hex_1));
    System.out.println(ConstHex.isConstHex(hex_2));
    System.out.println(ConstHex.isConstHex(invalid_hex_1));
    System.out.println(ConstHex.isConstHex(invalid_hex_2));
    System.out.println(ConstHex.isConstHex(invalid_hex_3));
    try{
      ConstHex const_hex_2 = new ConstHex(invalid_hex_2, 10, 1);
    } catch (Exception e) {
            System.out.println("Constante Hexadecimal inválida levantou erro!");
    }
    
  }
}
