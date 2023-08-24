package tests.lexer;

import lexer.Lexer;
import reader.TxtReader;

import java.util.ArrayList;

public class TestLexer {
    public static void main(String[] args) {
        ArrayList<String> lines = TxtReader.readFile("programa.txt");
        Lexer lexer = new Lexer(lines);
    }
}
