package tests.lexer.tags;

import lexer.tags.Identifier;

public class TestIdentifier {
    public static void main(String[] args) {
        String string1 = "a";
        String string2 = "b";
        String string3 = "while";
        String string4 = "0banana";

        Identifier r = new Identifier(string1, 10, 0);
        System.out.println(r);

        System.out.println(Identifier.isIdentifier(string1));
        System.out.println(Identifier.isIdentifier(string2));
        System.out.println(Identifier.isIdentifier(string3));
        System.out.println(Identifier.isIdentifier(string4));

        new Identifier(string4, 1, 0);
        System.out.println(r.getLexeme());
        System.out.println(r.getLine());
    }
}
