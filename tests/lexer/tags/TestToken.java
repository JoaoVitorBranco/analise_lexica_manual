package tests.lexer.tags;


import lexer.tags.Tag;
import lexer.tags.Token;

public class TestToken{
  public static void main(String[] args){
    Tag tag = Tag.CHAR;
    Token t = new Token(tag, 1, 0);
    System.out.println(t);
  }
}
