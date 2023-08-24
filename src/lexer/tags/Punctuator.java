package lexer.tags;


public class Punctuator extends Token{
  private final static String[] symbols = {"[","]","(",")",",",";"};
  private String symbol;

  public Punctuator(String operator, int line){
    super(Tag.PUNCTUATOR, line);

    setPunctuator(operator);

  }

  public static boolean isPunctuator(String s){
    for(String op : symbols){
      if(op.equals(s)){
        return true;
      }
    }
    return false;
  }

  public String getPunctuator(){
    return this.symbol;
  }

  public String toString(){
    return super.toString() +  this.symbol;
  }

  public void setPunctuator(String symbol) throws IllegalArgumentException{
    if(isPunctuator(symbol)){
      this.symbol = symbol;
    }else{
      throw new IllegalArgumentException("Pontuador inválido");
    }
  }

}
