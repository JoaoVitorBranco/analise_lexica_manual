package tests.reader;

import java.util.ArrayList;

import reader.TxtReader;



public class TestTxtReader {
    public static void main(String[] args) {
        ArrayList<String> lines = TxtReader.readFile("tests/reader/test.txt");
        System.out.println("Must contain 3 lines: " + String.valueOf(lines.size() == 3));
        System.out.println("Lines: ");
        for (String line : lines) {
            System.out.println(line);
        }
    }

}
