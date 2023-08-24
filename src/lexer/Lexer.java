package lexer;

import lexer.tags.*;

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
        this.line = 0;
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

        while(this.currentChar != '\n' && this.columns < line.length()){
            this.currentChar = line.charAt(this.columns);
            
            if(this.currentChar == ' ' || this.currentChar == '\t'){
                this.columns++;
                continue;
            } else if (Punctuator.isPunctuator(this.currentChar + "")) {
                Punctuator p = new Punctuator(this.currentChar + "", this.line);
                this.addTokenToBuffer(p);
            } else if (this.currentChar == '\'')
            {
                try{
                    char c = line.charAt(this.columns + 1);
                    char c2 = line.charAt(this.columns + 2);

                    if(c2 == '\''){
                        String s =  this.currentChar + ""  + c + c2;
                        Char r = new Char(s, this.line);
                        this.addTokenToBuffer(r);
                        this.columns += 3;
                    }
                    else {
                        throw new Exception("Char mal formado");
                    }

                }
                catch (Exception e){
                    System.out.println(e.getMessage());
                    System.exit(0);
                }


            }


            this.columns++;
        }
    }

    public void addTokenToBuffer(Token token){
        this.buffer.add(token);
    }

    public void printBuffer(){
        for(Token t : this.buffer){
            System.out.println(t);
        }
    }


}
