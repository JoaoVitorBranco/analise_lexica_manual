package lexer.tags;

public class Identifier extends Token{
    private String lexeme;

    public Identifier(String lexeme, int line, int column ){
        super(Tag.IDENTIFIER, line,column);
        setLexeme(lexeme);
    }


    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        if (! isIdentifier(lexeme)){
            throw new IllegalArgumentException("Identificador válido");
        }
        this.lexeme = lexeme;
    }

    public String toString(){
        return super.toString() + this.lexeme;
    }

    public static boolean isIdentifier(String identifier){
        char c1 = identifier.charAt(0);

        return (Character.isAlphabetic(c1) || c1 == '_') && !Reserved.isReserved(identifier);

    }


}
