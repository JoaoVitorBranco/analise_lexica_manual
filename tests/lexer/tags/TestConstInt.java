class TestConstInt{
  public static void main(String[] args){
    ConstInt c = new ConstInt(1, 10);
    System.out.println(c.getLine());
    System.out.println(c.getValue());

    ConstInt c2 = new ConstInt(2, 20);
    System.out.println(c2.getLine());
    System.out.println(c2.getValue());

    System.out.println(c);


  }
}