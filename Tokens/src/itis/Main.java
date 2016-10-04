package itis;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Input text");

        String text = new Scanner(System.in).nextLine();

        Tokenizer tokenizer1 = new SimpleTokenizerImpl();

        Token tokens[] = tokenizer1.parse(text);

        System.out.println("Tokens: " + Arrays.toString(tokens));

        Tokenizer tokenizer2 = new RegexTokenizerImpl();

        tokens = tokenizer2.parse(text);

        System.out.println("Tokens: " + Arrays.toString(tokens));
    }
}
