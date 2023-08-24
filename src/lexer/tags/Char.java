package lexer.tags;

public class Char extends Token {
    private String lexeme;

    public Char(String c, int line) throws IllegalArgumentException{
        super(Tag.CHAR, line);
        this.setLexeme(c);
    }

    public void setLexeme(String c) throws IllegalArgumentException{
        if (! isChar(c)){
            throw new IllegalArgumentException("Char válido");
        }
        else{
            this.lexeme = c;
        }
    }
    public String toString(){

        return super.toString() + this.lexeme;
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
