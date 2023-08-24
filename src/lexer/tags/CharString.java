package lexer.tags;

public class CharString extends  Token{
    private String lexeme;
    
    public CharString(String s, int line){
        super(Tag.STRING, line);

        this.setLexeme(s);
    }

    public String toString(){
        return "Cadeia de caracteres: " + this.lexeme;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }
}
