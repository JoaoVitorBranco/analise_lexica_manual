package lexer.tags;

public class Identifier extends Token{
    private String lexeme;

    public Identifier(String lexeme, int line){
        super(Tag.IDENTIFIER, line);
        try{
            setLexeme(lexeme);
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
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
        return "Identifier: " + this.lexeme;
    }

    public static boolean isIdentifier(String identifier){
        char c1 = identifier.charAt(0);

        return (Character.isAlphabetic(c1) || c1 == '_') && !Reserved.isReserved(identifier);

    }


}
