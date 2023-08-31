package lexer;

import lexer.tags.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Lexer {
    int columns;
    int line;
    boolean isComment = false;
    ArrayList<String> lines;
    private char currentChar = ' ';

    ArrayList<Token> buffer = new ArrayList<>();

    private final HashMap<String, Reserved> reservedTokens = new HashMap<>();
    private final HashMap<String, Identifier> identifierTokens = new HashMap<>();

    final void reserveReserved(Reserved token){
        this.reservedTokens.put(token.getLexeme(), token);
    }

    final void reserveIdentifier(Identifier token){
        this.identifierTokens.put(token.getLexeme(), token);
    }

    public Lexer(ArrayList<String> lines){
        this.columns = 0;
        this.line = 0;
        this.lines = lines;

        for(String s : Reserved.reservedWords){
            this.reserveReserved(new Reserved(s, 0, 0));
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
        if (this.isComment) {
            System.out.println("Comentário não fechado");
            System.exit(0);
        }
    }

    public void scanLine(String line){
        this.columns = 0;
        this.line++;
        this.currentChar = ' ';
        
        try{
            while(this.currentChar != '\n' && this.columns < line.length()){
                this.currentChar = line.charAt(this.columns);
                
                if (!this.isComment) {
                    if(this.currentChar == ' ' || this.currentChar == '\t') {
                        this.columns++;
                        continue;
                    } else if (this.currentChar == '"') { // CharString
                            int temp_columns = this.columns;
                            StringBuilder temp_lexeme = new StringBuilder();
                            temp_lexeme.append(this.currentChar);
                            
                            temp_columns++;
                            this.currentChar = line.charAt(temp_columns);
            
                            while(this.currentChar != '"' &&  temp_columns < line.length()){
                                temp_lexeme.append(this.currentChar);
                                temp_columns++;
                                if (temp_columns < line.length())
                                {
                                    this.currentChar = line.charAt(temp_columns);
                                }
                            }
                            
                            if(this.currentChar != '"'){
                                throw new Exception( this.line + ":" + this.columns + " Cadeia de caracteres mal formado");
                            }

                            temp_lexeme.append(this.currentChar);
                            String lexeme = temp_lexeme.toString();
                            CharString cs = new CharString(lexeme, this.line, this.columns);
                            this.addTokenToBuffer(cs);
                            this.columns = temp_columns;
                            

                    } else if (Punctuator.isPunctuator(this.currentChar + "")) { // Punctuator
                        Punctuator p = new Punctuator(this.currentChar + "", this.line, this.columns);
                        this.addTokenToBuffer(p);
                    } else if (this.currentChar == '\'') { // Char
                        char c = line.charAt(this.columns + 1);
                        char c2 = line.charAt(this.columns + 2);

                        if(c2 == '\''){
                            String s =  this.currentChar + ""  + c + c2;
                            Char r = new Char(s, this.line, this.columns);
                            this.addTokenToBuffer(r);
                            this.columns += 3 - 1;
                        }
                        else {
                            throw new Exception( this.line + ":" + this.columns + " Char mal formado");
                        }
                    } else if (Character.isAlphabetic(this.currentChar)) { // Identifier and Reserved
                        int temp_columns = this.columns;
                        StringBuilder temp_lexeme = new StringBuilder();
        
                        while((Character.isAlphabetic(this.currentChar) || Character.isDigit(this.currentChar)) &&  temp_columns < line.length()){
                            temp_lexeme.append(this.currentChar);
                            temp_columns++;
                            if (temp_columns < line.length())
                            {
                                this.currentChar = line.charAt(temp_columns);
                            }
                        }
        
                        String lexeme = temp_lexeme.toString();
        
                        if (reservedTokens.get(lexeme) != null) {
                            Reserved r = reservedTokens.get(lexeme);
                            r.setLine(this.line);
                            r.setColumn(this.columns);
                            this.addTokenToBuffer(r);
                        } else if (identifierTokens.get(lexeme) != null) {
                            Identifier i = identifierTokens.get(lexeme);
                            i.setLine(this.line);
                            i.setColumn(this.columns);
                            this.addTokenToBuffer(i);
                        } else {
                            Identifier i = new Identifier(lexeme, this.line, this.columns);
                            this.addTokenToBuffer(i);
                            this.reserveIdentifier(i);
                        }
                        this.columns += lexeme.length() - 1;
                    } else if(this.currentChar == '+' || this.currentChar == '-') { // Operator, ConstInt or ConstReal
                        StringBuilder temp_lexeme = new StringBuilder();
                        temp_lexeme.append(this.currentChar);
                        int temp_columns = this.columns;
                        temp_columns++;
                        boolean is_plus_or_minus = false;
                        if(temp_columns >= line.length()){
                            is_plus_or_minus = true;
                        } else {
                            this.currentChar = line.charAt(temp_columns);
                            if(this.currentChar == ' ' || this.currentChar == '\t' || this.currentChar == '\n'){
                                is_plus_or_minus = true;
                            }
                        }
                        if(is_plus_or_minus){
                            String s = temp_lexeme.toString();
                            Operator o = new Operator(s, this.line, this.columns);
                            this.addTokenToBuffer(o);
                            this.columns = temp_columns;
                        } else if(Operator.isOperator(temp_lexeme.toString() + this.currentChar)){
                            String s = temp_lexeme.toString() + this.currentChar;
                            Operator o = new Operator(s, this.line, temp_columns);
                            this.addTokenToBuffer(o);
                            this.columns = temp_columns;
                        } else if(Character.isDigit(this.currentChar)){
                            temp_lexeme.append(this.currentChar);
        
                            if(temp_columns == line.length() - 1){
                                ConstInt c = new ConstInt(temp_lexeme.toString(), this.line, this.columns);
                                this.addTokenToBuffer(c);
                                this.columns = temp_columns;
                            } else {
                                temp_columns++;
                                this.currentChar = line.charAt(temp_columns);
                                boolean just_one_dot = false;
                                boolean digit_between_dot_and_e = false;
                                boolean just_one_e = false;
                                boolean just_one_signal = false;
                                boolean last_char_is_e = false;
        
                                while(this.currentChar != ' ' && this.currentChar != '\t' && this.currentChar != '\n'){
                                    if(this.currentChar == '.' && !just_one_dot){ 
                                        just_one_dot = true;
                                        digit_between_dot_and_e = false;
                                    }
                                    else if(Character.isDigit(this.currentChar)){
                                        digit_between_dot_and_e = true;
                                        last_char_is_e = false;
                                    }
                                    else if(!just_one_e && digit_between_dot_and_e && just_one_dot && (this.currentChar == 'e' || this.currentChar == 'E')){
                                        just_one_e = true;
                                        last_char_is_e = true;
                                    }
                                    else if(just_one_dot && last_char_is_e && just_one_e && digit_between_dot_and_e && !just_one_signal &&(this.currentChar == '+' || this.currentChar == '-')){
                                        just_one_signal = true;
                                    }
                                    else{
                                        throw new Exception( this.line + ":" + temp_columns + " Constante Numérica mal formatada" );
                                    }
                                    temp_lexeme.append(this.currentChar);
                                    temp_columns++;
                                    if(temp_columns == line.length()){
                                        break;
                                    }
                                    this.currentChar = line.charAt(temp_columns);
                                }
                                String s = temp_lexeme.toString();
                                if(Character.isDigit(s.charAt(s.length() - 1))){
                                    if(s.indexOf('.') != -1){
                                        ConstReal c = new ConstReal(s, this.line, this.columns);
                                        this.addTokenToBuffer(c);
                                    }
                                    else{
                                        ConstInt c = new ConstInt(s, this.line, this.columns);
                                        this.addTokenToBuffer(c);
        
                                    }
                                    this.columns = temp_columns;
                                }
                                else{
                                    throw new Exception( this.line + ":" + temp_columns + " Constante Numérica mal formatada" );
                                }
                            }
                        } else{
                            throw new Exception( this.line + ":" + temp_columns + " Operador mal formatado" );
                        }
                    } else if (this.currentChar == '0') { // ConstInt, ConstHex, ConstOct or ConstReal
                        StringBuilder temp_lexeme = new StringBuilder();
                        temp_lexeme.append(this.currentChar);
                        int temp_columns = this.columns;
                        temp_columns++;
                        if(temp_columns >= line.length()){ // ConstInt
                            ConstInt c = new ConstInt(temp_lexeme.toString(), this.line, this.columns);
                            this.addTokenToBuffer(c);
                        }
                        else if(line.charAt(temp_columns) == ' ' || line.charAt(temp_columns) == '\t' | line.charAt(temp_columns) == '\n'){
                            ConstInt c = new ConstInt(temp_lexeme.toString(), this.line, this.columns);
                            this.addTokenToBuffer(c);
                        } else { 
                            this.currentChar = line.charAt(temp_columns);
                            temp_lexeme.append(this.currentChar);
                            if(Character.toLowerCase(this.currentChar) == 'x'){ // ConstHex
                                temp_columns++;
                                this.currentChar = line.charAt(temp_columns);
                                if(Character.isDigit(this.currentChar) || (Character.toLowerCase(this.currentChar) >= 'a' && Character.toLowerCase(this.currentChar) <= 'f')){
                                    while(Character.isDigit(this.currentChar) || (Character.toLowerCase(this.currentChar) >= 'a' && Character.toLowerCase(this.currentChar) <= 'f')){
                                        temp_lexeme.append(this.currentChar);
                                        temp_columns++;
                                        if(temp_columns == line.length()){
                                            break;
                                        }
                                        this.currentChar = line.charAt(temp_columns);
                                    }
                                    String s = temp_lexeme.toString();
                                    ConstHex c = new ConstHex(s, this.line, this.columns);
                                    this.addTokenToBuffer(c);
                                    this.columns = temp_columns;
                                } else{
                                    throw new Exception( this.line + ":" + temp_columns + " Constante Hexadecimal mal formatada" );
                                }
                            } else if(Character.isDigit(this.currentChar)){ // ConstOct
                                while(Character.isDigit(this.currentChar)){
                                    temp_lexeme.append(this.currentChar);
                                    if("01234567".indexOf(this.currentChar) == -1){
                                        throw new Exception( this.line + ":" + temp_columns + " Constante Octal mal formatada" );
                                    }
                                    temp_columns++;
                                    if(temp_columns == line.length()){
                                        break;
                                    }
                                    this.currentChar = line.charAt(temp_columns);
                                }
                                String s = temp_lexeme.toString();
                                ConstOct c = new ConstOct(s, this.line, this.columns);
                                this.addTokenToBuffer(c);
                                this.columns = temp_columns;
                            } else if(this.currentChar == '.'){ // ConstReal
                                temp_columns++;
                                this.currentChar = line.charAt(temp_columns);
                                boolean just_one_dot = true;
                                boolean digit_between_dot_and_e = false;
                                boolean just_one_e = false;
                                boolean just_one_signal = false;
                                boolean last_char_is_e = false;
        
                                while(this.currentChar != ' ' && this.currentChar != '\t' && this.currentChar != '\n'){
                                    if(this.currentChar == '.' && !just_one_dot){ 
                                        just_one_dot = true;
                                        digit_between_dot_and_e = false;
                                    }
                                    else if(Character.isDigit(this.currentChar)){
                                        digit_between_dot_and_e = true;
                                        last_char_is_e = false;
                                    }
                                    else if(!just_one_e && digit_between_dot_and_e && just_one_dot && (this.currentChar == 'e' || this.currentChar == 'E')){
                                        just_one_e = true;
                                        last_char_is_e = true;
                                    }
                                    else if(just_one_dot && last_char_is_e && just_one_e && digit_between_dot_and_e && !just_one_signal &&(this.currentChar == '+' || this.currentChar == '-')){
                                        just_one_signal = true;
                                    }
                                    else{
                                        throw new Exception( this.line + ":" + temp_columns + " Constante Real mal formatada" );
                                    }
                                    temp_lexeme.append(this.currentChar);
                                    temp_columns++;
                                    if(temp_columns == line.length()){
                                        break;
                                    }
                                    this.currentChar = line.charAt(temp_columns);
                                }
                                String s = temp_lexeme.toString();
                                ConstReal c = new ConstReal(s, this.line, this.columns);
                                this.addTokenToBuffer(c);
                            } else{
                                throw new Exception( this.line + ":" + temp_columns + " Operador mal formatado" );
                            }
                        }
                        this.columns = temp_columns;

                    } else if (Character.isDigit(this.currentChar)) { // ConstInt or ConstReal
                        StringBuilder temp_lexeme = new StringBuilder();
                        temp_lexeme.append(this.currentChar);
                        int temp_columns = this.columns;
                        temp_columns++;
                        if(temp_columns >= line.length()){ // ConstInt
                            ConstInt c = new ConstInt(temp_lexeme.toString(), this.line, this.columns);
                            this.addTokenToBuffer(c);
                        }
                        else if(line.charAt(temp_columns) == ' ' || line.charAt(temp_columns) == '\t' | line.charAt(temp_columns) == '\n'){
                            ConstInt c = new ConstInt(temp_lexeme.toString(), this.line, this.columns);
                            this.addTokenToBuffer(c);
                        }
                        else{
                            this.currentChar = line.charAt(temp_columns);
                            boolean just_one_dot = false;
                            boolean digit_between_dot_and_e = false;
                            boolean just_one_e = false;
                            boolean just_one_signal = false;
                            boolean last_char_is_e = false;
        
                            while(this.currentChar != ' ' && this.currentChar != '\t' && this.currentChar != '\n'){
                                if(this.currentChar == '.' && !just_one_dot){ 
                                    just_one_dot = true;
                                    digit_between_dot_and_e = false;
                                }
                                else if(Character.isDigit(this.currentChar)){
                                    digit_between_dot_and_e = true;
                                    last_char_is_e = false;
                                }
                                else if(!just_one_e && digit_between_dot_and_e && just_one_dot && (this.currentChar == 'e' || this.currentChar == 'E')){
                                    just_one_e = true;
                                    last_char_is_e = true;
                                }
                                else if(just_one_dot && last_char_is_e && just_one_e && digit_between_dot_and_e && !just_one_signal &&(this.currentChar == '+' || this.currentChar == '-')){
                                    just_one_signal = true;
                                }
                                else{
                                    throw new Exception( this.line + ":" + temp_columns + " Constante Numérica mal formatada" );
                                }
                                temp_lexeme.append(this.currentChar);
                                temp_columns++;
                                if(temp_columns >= line.length()){
                                    break;
                                }
                                this.currentChar = line.charAt(temp_columns);
                            }
                            String s = temp_lexeme.toString();
                            if(Character.isDigit(s.charAt(s.length() - 1))){
                                if(s.indexOf('.') != -1){
                                    ConstReal c = new ConstReal(s, this.line, this.columns);
                                    this.addTokenToBuffer(c);
                                }
                                else{
                                    ConstInt c = new ConstInt(s, this.line, this.columns);
                                    this.addTokenToBuffer(c);
        
                                }
                                this.columns = temp_columns;
                            }
                            else{
                                throw new Exception( this.line + ":" + temp_columns + " Constante Numérica mal formatada" );
                            }
                        }
                    } else if (Operator.isOperator(this.currentChar + "")) { // Operator
                        if(this.columns != line.length() - 1){
                            if(line.charAt(this.columns + 1) != ' ' && line.charAt(this.columns + 1) != '\t' && line.charAt(this.columns + 1) != '\n'){
                                throw new Exception( this.line + ":" + this.columns + " Operador mal formatado" );
                            }
                        }
                        String s = this.currentChar + "";
                        Operator o = new Operator(s, this.line, this.columns);
                        this.addTokenToBuffer(o);
                    
                        
                    } else if (this.currentChar == '/') { // Ignorar comentários
                        int temp_columns = this.columns + 1;

                        if(line.charAt(temp_columns) == '/'){
                            break;
                        }else if(line.charAt(temp_columns) == '*'){
                            this.isComment = true;
                        }

                    } else { // Invalid Character
                        throw new Exception( this.line + ":" + this.columns + " Caractere inválido" );
                    }

                this.columns++;
            } else {
                if(this.currentChar == '*'){
                    int temp_columns = this.columns + 1;
                    if(line.charAt(temp_columns) == '/'){
                        this.isComment = false;
                        this.columns++;
                    }
                }
                this.columns++;
            }
        }
    }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.exit(0);
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
