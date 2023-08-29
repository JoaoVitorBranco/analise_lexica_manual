

import lexer.tags.Operator;

public class TestOperator{
  public static void main(String[] args) {
    String operator_1 = "+";
    String operator_2 = "-";
    String operator_3 = "*";

    String invalid_operator = "a";

    System.out.println(Operator.isOperator(operator_1));
    System.out.println(Operator.isOperator(operator_2));
    System.out.println(Operator.isOperator(operator_3));
    System.out.println(Operator.isOperator(invalid_operator));

    Operator operator = new Operator(operator_1, 10, 0);
    System.out.println(operator.getOperator());
    System.out.println(operator.getLine());
    
    try{
      Operator invalid_op = new Operator(invalid_operator, 10, 0);
    } catch (Exception e) {
            System.out.println("Operador inválido levantou erro!");
    }
    
  }
}
