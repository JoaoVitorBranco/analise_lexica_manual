package lexer.tags;

public class Char extends Token {
    private String lexeme;

    public Char(String c, int line){
        super(Tag.CHAR, line);

        try{
            this.setLexeme(c);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    public void setLexeme(String c){
        if (! isChar(c)){
            throw new IllegalArgumentException("Char válido");
        }
        else{
            this.lexeme = c;
        }
    }
    public String toString(){
        return "Char: " + this.lexeme;
    }

    public static boolean isChar(String c){

        char Char1 = c.charAt(0);
        char Char2 = c.charAt(c.length()-1);

        return Char1 == '\'' && Char2 == '\'' && c.length() == 3;
    }

    public String getLexeme() {
        return this.lexeme;
    }
}
