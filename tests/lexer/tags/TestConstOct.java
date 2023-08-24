package tests.lexer.tags;


import lexer.tags.ConstOct;

public class TestConstOct {
  public static void main(String[] args) {
    String oct_1 = "010";
    String invalid_oct_1 = "10";

    System.out.println(ConstOct.isConstOct(oct_1));

    ConstOct const_oct_1 = new ConstOct(oct_1, 10);
    System.out.println(const_oct_1.getOct());
    System.out.println(const_oct_1.getLine());
    System.out.println(const_oct_1);

    ConstOct const_oct_2 = new ConstOct(invalid_oct_1, 10);
    System.out.println(ConstOct.isConstOct(invalid_oct_1));
  }
}
