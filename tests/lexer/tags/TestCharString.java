
import lexer.tags.CharString;

public class TestCharString {

    public static void main(String[] args) {
        String string1 = "\"banana\"";
        CharString s1 = new CharString(string1, 1, 2);

        System.out.println(s1);

    }


}
