package lexer.tags;


public class Reserved extends Token{
    public static String[] reservedWords = {"if", "do", "else", "while", "char", "until", "void", "int"};
    private String lexeme;
    

    public Reserved(String lexeme, int line, int column ) throws IllegalArgumentException {
        super(Tag.RESERVED, line,column);
        this.setLexeme(lexeme);

    }

    public String getLexeme(){
        return this.lexeme;
    }

    public void setLexeme(String lexeme) throws IllegalArgumentException{

      if (isReserved(lexeme)){
        this.lexeme = lexeme;
      } else {
        throw new IllegalArgumentException("Palavra reservada inválida");
      }

    }

    public String toString(){
        return super.toString() + this.lexeme;
    }

    public static boolean isReserved(String word){
        for(String s : reservedWords){
            if(s.equals(word)
            ){
                return true;
            }
        }
        return false;
    }  
}
