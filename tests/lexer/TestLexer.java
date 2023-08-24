package tests.lexer;

import lexer.Lexer;
import reader.TxtReader;

import java.util.ArrayList;

public class TestLexer {
    public static void main(String[] args) {
//        ArrayList<String> lines = TxtReader.readFile("programa.txt");
//        Lexer lexer = new Lexer(lines);

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

    }
}
