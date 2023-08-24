package lexer.tags;


public class Punctuator extends Token{
  private final static String[] simbols = {"[","]","(",")",",",";"};
  private String simbol;

  Punctuator(String operator, int line){
    super(Tag.PUNCTUATOR, line);

    try{
      setPunctuator(simbol);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }

  }

  public static boolean isPunctuator(String s){
    for(String op : simbols){
      if(op.equals(s)){
        return true;
      }
    }
    return false;
  }

  public String getPunctuator(){
    return this.simbol;
  }

  public String toString(){
    return "Punctuator: " +  this.simbol;
  }

  public void setPunctuator(String simbol) throws Exception{
    if(isPunctuator(simbol)){
      this.simbol = simbol;
    }else{
      throw new Exception("Pontuador inválido");
    }
  }

}
