package lexer.tags;

public class ConstInt extends Token{
  private int value;

  public ConstInt(String value, int line){
    super(Tag.INT, line);
    setValue(value);
  }
  public ConstInt(int value, int line){
    super(Tag.INT, line);
    this.value = value;
  }


  public int getValue(){
    return this.value;
  }

  public String toString(){
    return "Int: " + this.value;
  }

  public void setValue(String s) throws IllegalArgumentException{
    if (!isConstInt(s))
    {
       throw new IllegalArgumentException("Inteiro inválido");

    }
    else{
        this.value = Integer.parseInt(s);
    }
  }

  public static boolean isConstInt(String s){
    try{
      int signal = 1;
      if (s.charAt(0) == '-'){
        signal = -1;
        s = s.substring(1);
      }
      else if (s.charAt(0) == '+'){
        s = s.substring(1);
      }

      Integer.parseInt(s);
      return true;
    }catch(NumberFormatException e){
      return false;
    }
  }
}
