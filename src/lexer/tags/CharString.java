package lexer.tags;

public class CharString extends  Token{
    private String lexeme;
    
    public CharString(String s, int line, int column){
        super(Tag.STRING, line, column);

        this.setLexeme(s);
    }

    public String toString(){
        return super.toString() + this.lexeme;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }
}
