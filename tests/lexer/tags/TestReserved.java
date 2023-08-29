

import lexer.tags.Reserved;

public class TestReserved {
    public static void main(String[] args) {
      String if_string = "if";
      String else_string = "else";
      String wrong_string = "banana";

      System.out.println(Reserved.isReserved(if_string));
      System.out.println(Reserved.isReserved(else_string));
      System.out.println(Reserved.isReserved(wrong_string));
      try{
        new Reserved(wrong_string, 1, 0);
      } catch (Exception e) {
            System.out.println("Palvra reservada inválido levantou erro!");
      }
      

      Reserved r = new Reserved(if_string, 10, 0);
      System.out.println(r.getLexeme());
      System.out.println(r.getLine());

    }
}
