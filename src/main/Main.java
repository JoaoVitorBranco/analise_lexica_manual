package main;

import lexer.Lexer;
import reader.TxtReader;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = TxtReader.readFile("programa.txt");
        Lexer lexer = new Lexer(lines);

        lexer.scanLines();
        lexer.printBuffer();


    }
}
