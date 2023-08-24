package lexer.tags;

public class CharString extends  Token{
    private String lexeme;
    
    public CharString(String s, int line){
        super(Tag.STRING, line);

        try{
            this.setLexeme(s);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
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
