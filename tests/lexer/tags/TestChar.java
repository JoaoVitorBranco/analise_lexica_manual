package tests.lexer.tags;

import lexer.tags.Char;

public class TestChar {
    public static void main(String[] args) {
        String string1 = "'a'";
        String string2 = "'b'";
        String string3 = "'banana'";
        String string4 = "\'0";

        System.out.println(Char.isChar(string1));
        System.out.println(Char.isChar(string2));
        System.out.println(Char.isChar(string3));
        System.out.println(Char.isChar(string4));

        new Char(string3, 1);

        Char r = new Char(string1, 10);
        System.out.println(r.getLexeme());
        System.out.println(r.getLine());
    }
}
