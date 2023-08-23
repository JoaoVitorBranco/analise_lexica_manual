class ConstInt extends Token{
  private int value;

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

  public void setValue(int value){
    this.value = value;
  }

  public static boolean isConstInt(String s){
    try{
      Integer.parseInt(s);
      return true;
    }catch(NumberFormatException e){
      return false;
    }
  }
}