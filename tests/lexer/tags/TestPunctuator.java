
import lexer.tags.Punctuator;

public class TestPunctuator {
    public static void main(String[] args) {
        String string1 = ";";
        String string2 = ")";
        String string3 = "banana";

        Punctuator r = new Punctuator(string1, 10, 0);
        System.out.println(r);
        System.out.println(Punctuator.isPunctuator(string1));
        System.out.println(Punctuator.isPunctuator(string2));
        System.out.println(Punctuator.isPunctuator(string3));

        try{
            new Punctuator(string3, 1, 0);
        } catch (Exception e) {
            System.out.println("Pontuador inválido levantou erro!");
        }
        

        System.out.println(r.getPunctuator());
        System.out.println(r.getLine());

    }
}
