package lexer.tags;


public class Operator extends Token {
  private final static String[] operators = {"++", "--", "&", "*", "+", "-", "~", "!", ","};
  private String operator;

  public Operator(String operator, int line){
    super(Tag.OPERATOR, line);

    setOperator(operator);

  }

  public static boolean isOperator(String s){
    for(String op : operators){
      if(op.equals(s)){
        return true;
      }
    }
    return false;
  }

  public String getOperator(){
    return this.operator;
  }

  public String toString(){
    return  super.toString() +  this.operator;
  }

  public void setOperator(String operator) throws IllegalArgumentException{
    if(isOperator(operator)){
      this.operator = operator;
    }else{
      throw new IllegalArgumentException("Operador inválido");
    }
  }

}
