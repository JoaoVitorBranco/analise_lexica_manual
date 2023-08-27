package tests.lexer;

import lexer.Lexer;
import reader.TxtReader;

import java.util.ArrayList;

public class TestLexer {
    public static void main(String[] args) {
//        ArrayList<String> lines = TxtReader.readFile("programa.txt");
//        Lexer lexer = new Lexer(lines);
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
        
        // Operators with length 1
        System.out.println("\n============ Operators with length 1 ============");
        ArrayList<String> opStringL1 = new ArrayList<>();
        opStringL1.add("& * ~ !");
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
        
        
    }
}
