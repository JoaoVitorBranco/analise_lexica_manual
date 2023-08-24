package lexer.tags;


public class Reserved extends Token{
    private static String[] reservedWords = {"if", "do", "else", "while", "char", "until", "void", "int"};
    private String lexeme;
    

    public Reserved(String lexeme, int line){
        super(Tag.RESERVED, line);
        try{
            setLexeme(lexeme);
        } catch (Exception e){
            System.out.println(e.getMessage());        
        }
    }

    public String getLexeme(){
        return this.lexeme;
    }

    public void setLexeme(String lexeme) throws Exception{

      if (isReserved(lexeme)){
        this.lexeme = lexeme;
      } else {
        throw new Exception("Palavra reservada inválida");
      }

    }

    public String toString(){
        return "Reserved: " + super.toString();
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
