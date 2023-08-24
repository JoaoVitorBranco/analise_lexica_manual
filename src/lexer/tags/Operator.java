package lexer.tags;


public class Operator extends Token {
  private final static String[] operators = {"++", "--", "&", "*", "+", "-", "~", "!", ","};
  private String operator;

  public Operator(String operator, int line){
    super(Tag.OPERATOR, line);
    
    try{
      setOperator(operator);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }

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
    return "Oprator: " +  this.operator;
  }

  public void setOperator(String operator) throws Exception{
    if(isOperator(operator)){
      this.operator = operator;
    }else{
      throw new Exception("Operador inválido");
    }
  }

}
