package tests.lexer;

import lexer.Lexer;
import reader.TxtReader;

import java.util.ArrayList;

public class TestLexer {
    public static void main(String[] args) {
//        ArrayList<String> lines = TxtReader.readFile("programa.txt");
//        Lexer lexer = new Lexer(lines);
        System.out.println("Testes do Lexer");

        // Pontuadores
        System.out.println("Puntuadores");
        ArrayList<String> punctuators = new ArrayList<>();
        punctuators.add("; ]");
        punctuators.add(", ");
        punctuators.add("( ");

        Lexer l_punctuators = new Lexer(punctuators);

        l_punctuators.scanLines();
        l_punctuators.printBuffer();

        // Caracteres
        System.out.println("Caracteres");
        ArrayList<String> characters = new ArrayList<>();
        characters.add("'a' ");
        characters.add("'b' ");
        characters.add("'c' ");

        Lexer l_characters = new Lexer(characters);
        l_characters.scanLines();
        l_characters.printBuffer();

        // Identificadores
        System.out.println("Identificadores");
        ArrayList<String> identifiers = new ArrayList<>();
        identifiers.add("a ");
        identifiers.add("vitor joao andre ");

        Lexer l_identifiers = new Lexer(identifiers);
        l_identifiers.scanLines();
        l_identifiers.printBuffer();

        // Palavras reservadas
        System.out.println("Palavras reservadas");
        ArrayList<String> reservedWords = new ArrayList<>();
        reservedWords.add("if");
        reservedWords.add("else ");

        Lexer l_reservedWords = new Lexer(reservedWords);
        l_reservedWords.scanLines();
        l_reservedWords.printBuffer();

        // Identificadores e palavras reservadas
        System.out.println("Identificadores e palavras reservadas");
        ArrayList<String> identifiersAndReservedWords = new ArrayList<>();
        identifiersAndReservedWords.add("if vitor joao while");
        identifiersAndReservedWords.add("else andre");


        Lexer l_identifiersAndReservedWords = new Lexer(identifiersAndReservedWords);
        l_identifiersAndReservedWords.scanLines();
        l_identifiersAndReservedWords.printBuffer();

    }
}
