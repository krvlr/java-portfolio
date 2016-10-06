package itis.Solution;

import itis.Tokens.*;
import itis.Tokens.Number;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SimpleTokenizerImplTest {

    private SimpleTokenizerImpl tokenizer;

    private static final String TEXT_TO_PARSE = "Hello, world! 123";
    private static final Token[] PARSED_TEXT = generateParsedText();

    private static Token[] generateParsedText() {
        Token word1 = new Word(0, 4, TokensEnum.WORD, "Hello");
        Token punctuation1 = new Punctuation(5, 5, TokensEnum.PUNCTUATION, ",");
        Token word2 = new Word(7, 11, TokensEnum.WORD, "world");
        Token punctuation2 = new Punctuation(12, 12, TokensEnum.PUNCTUATION, "!");
        Token number = new Number(14, 16, TokensEnum.NUMBER, "123");

        Token[] result = {word1, punctuation1, word2, punctuation2, number};

        return result;
    }

    @org.junit.Before
    public void setUp() throws Exception {
        tokenizer = new SimpleTokenizerImpl();
    }

    @org.junit.Test
    public void parse() throws Exception {
        Token[] expected = PARSED_TEXT;
        Token[] actual = tokenizer.parse(TEXT_TO_PARSE);
        Arrays.equals(actual, expected);
    }
}