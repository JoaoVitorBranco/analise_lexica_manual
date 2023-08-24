package lexer;

import lexer.tags.Identifier;
import lexer.tags.Reserved;
import lexer.tags.Token;

import java.util.ArrayList;
import java.util.HashMap;

public class Lexer {
    int columns;
    int line;
    ArrayList<String> lines;
    private char currentChar = ' ';

    ArrayList<Token> buffer = new ArrayList<>();

    private final HashMap<String, Reserved> reservedTokens = new HashMap<>();
    private final HashMap<String, Identifier> identifierToken = new HashMap<>();

    final void reserveReserved(Reserved token){
        this.reservedTokens.put(token.getLexeme(), token);
    }

    final void reserveIdentifier(Identifier token){
        this.identifierToken.put(token.getLexeme(), token);
    }

    public Lexer(ArrayList<String> lines){
        this.columns = 0;
        this.line = 1;
        this.lines = lines;

        for(String s : Reserved.reservedWords){
            this.reserveReserved(new Reserved(s, 0));
        }
    }

    public void printLines(){
        for(String s : this.lines){
            System.out.println(s);
        }
    }
    public void scanLines(){
        for(String s : this.lines){
            this.scanLine(s);
        }
    }

    public void scanLine(String line){
        this.columns = 0;
        this.line++;
        this.currentChar = ' ';

        while(this.currentChar != '\n'){
            this.currentChar = line.charAt(this.columns);


            this.columns++;
        }
    }

    public void addTokenToBuffer(Token token){
        this.buffer.add(token);
    }






}
