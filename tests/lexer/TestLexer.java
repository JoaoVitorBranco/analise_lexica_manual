package tests.lexer;

import lexer.Lexer;
import reader.TxtReader;

import java.util.ArrayList;

public class TestLexer {
    public static void main(String[] args) {

        System.out.println("====== Testes do Lexer ======");

        // Pontuadores
        System.out.println("============ Puntuadores ============");
        ArrayList<String> punctuators = new ArrayList<>();
        punctuators.add("; ]");
        punctuators.add(", ");
        punctuators.add("( ");

        Lexer l_punctuators = new Lexer(punctuators);

        l_punctuators.scanLines();
        l_punctuators.printBuffer();

        // Caracteres
        System.out.println("\n============ Caracteres ============");
        ArrayList<String> characters = new ArrayList<>();
        characters.add("'a' ");
        characters.add("'b' ");
        characters.add("'c' ");

        Lexer l_characters = new Lexer(characters);
        l_characters.scanLines();
        l_characters.printBuffer();

        // Identificadores
        System.out.println("\n============ Identificadores ============");
        ArrayList<String> identifiers = new ArrayList<>();
        identifiers.add("a ");
        identifiers.add("vitor joao andre ");
        identifiers.add("v1 c2 vitor12312 ");

        Lexer l_identifiers = new Lexer(identifiers);
        l_identifiers.scanLines();
        l_identifiers.printBuffer();

        // Palavras reservadas
        System.out.println("\n============ Palavras reservadas ============");
        ArrayList<String> reservedWords = new ArrayList<>();
        reservedWords.add("if");
        reservedWords.add("else ");

        Lexer l_reservedWords = new Lexer(reservedWords);
        l_reservedWords.scanLines();
        l_reservedWords.printBuffer();

        // Identificadores e palavras reservadas
        System.out.println("\n============ Identificadores e palavras reservadas ============");
        ArrayList<String> identifiersAndReservedWords = new ArrayList<>();
        identifiersAndReservedWords.add("if vitor2 joao while");
        identifiersAndReservedWords.add("else andre");


        Lexer l_identifiersAndReservedWords = new Lexer(identifiersAndReservedWords);
        l_identifiersAndReservedWords.scanLines();
        l_identifiersAndReservedWords.printBuffer();
        
        // CharString
        System.out.println("\n============ CharString ============");
        ArrayList<String> charString1 = new ArrayList<>();
        charString1.add("\"vitor\" ");
        charString1.add("\"joao asdas d@ ad a23123 :><>'''\" ");
        
        Lexer l_charString1 = new Lexer(charString1);
        l_charString1.scanLines();
        l_charString1.printBuffer();
        
        
        // CharString, Identificadores, Caractere e Pontuadores 
        System.out.println("\n============ CharString, Identificadores, Caractere e Pontuadores ============");
        ArrayList<String> charString2 = new ArrayList<>();
        charString2.add("\"andre \" var1 ; 'i'");
        Lexer l_charString2 = new Lexer(charString2);
        l_charString2.scanLines();
        l_charString2.printBuffer();
        
        // // CharString, Identificadores, Caractere e Pontuadores 
        // System.out.println("\n============ Erro no CharString ============");
        // ArrayList<String> charString3 = new ArrayList<>();
        // charString3.add("dasd asda ; \"andre das @");
        // Lexer l_charString3 = new Lexer(charString3);
        // l_charString3.scanLines();
        // l_charString3.printBuffer();
        
        // Operators
        System.out.println("\n============ Operators ============");
        ArrayList<String> opStringL1 = new ArrayList<>();
        opStringL1.add("& * ~ ! -- ++ -> + -");
        Lexer l_opStringL1 = new Lexer(opStringL1);
        l_opStringL1.scanLines();
        l_opStringL1.printBuffer();
        
        // CharString, Identificadores, Caractere, Pontuadores e Operadores de tamanho 1 
        System.out.println("\n============ CharString, Identificadores, Caractere, Pontuadores e Operadores de Tamanho 1 ============");
        ArrayList<String> mix1 = new ArrayList<>();
        mix1.add("\"andre ~\" & var1 ; 'i' ");
        Lexer l_mix1 = new Lexer(mix1);
        l_mix1.scanLines();
        l_mix1.printBuffer();

        // ConstInt
        System.out.println("\n============ ConstInt with +/- ============");
        ArrayList<String> constInt1 = new ArrayList<>();
        constInt1.add("+0 +1231231 -0123 +11 -0 -1");
        Lexer l_constInt1 = new Lexer(constInt1);
        l_constInt1.scanLines();
        l_constInt1.printBuffer();

        // ConstReal
        System.out.println("\n============ ConstReal with +/- ============");
        ArrayList<String> constReal1 = new ArrayList<>();
        constReal1.add("+1.1 -2.0 +22.11 -0.00 +02.1 +1.1e1 -2.22e4 +22.11e-1 -0.00e+1 +02.1e-1");
        Lexer l_constReal1 = new Lexer(constReal1);
        l_constReal1.scanLines();
        l_constReal1.printBuffer();
        
        // ConstInt 0
        System.out.println("\n============ ConstReal 0 ============");
        ArrayList<String> constReal01 = new ArrayList<>();
        constReal01.add("0");
        constReal01.add("0 ");
        Lexer l_constReal01 = new Lexer(constReal01);
        l_constReal01.scanLines();
        l_constReal01.printBuffer();
        
        // ConstHex
        System.out.println("\n============ ConstHex ============");
        ArrayList<String> constHex = new ArrayList<>();
        constHex.add("0x0 0x001 0x1 0xa 0xaa 0xf2b 0xabcdef");
        constHex.add("0xabcdef ");
        Lexer l_constHex = new Lexer(constHex);
        l_constHex.scanLines();
        l_constHex.printBuffer();

        // ConstOct
        System.out.println("\n============ ConstOct ============");
        ArrayList<String> constOct = new ArrayList<>();
        constOct.add("00 012 0135467 01654327");
        constOct.add("007 02 ");
        Lexer l_constOct = new Lexer(constOct);
        l_constOct.scanLines();
        l_constOct.printBuffer();
        
        // ConstReal with first char as 0
        System.out.println("\n============ ConstReal with first char as 0 ============");
        ArrayList<String> constReal0 = new ArrayList<>();
        constReal0.add("0.12 0.1E+02");
        constReal0.add("0.2 0.12E2 0.5e-231 ");
        Lexer l_constReal0 = new Lexer(constReal0);
        l_constReal0.scanLines();
        l_constReal0.printBuffer();

        // ConstInt starting with digit
        System.out.println("\n============ ConstInt starting with digit ============");
        ArrayList<String> constInt2 = new ArrayList<>();
        constInt2.add("1 12378831 0123 11 0 1 ");
        constInt2.add("9");
        Lexer l_constInt2 = new Lexer(constInt2);
        l_constInt2.scanLines();
        l_constInt2.printBuffer();

        
    }
}
