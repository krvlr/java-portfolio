package itis.Solution;

import itis.Tokens.Punctuation;
import itis.Tokens.Token;
import itis.Tokens.TokensEnum;
import itis.Tokens.Word;
import itis.Tokens.Number;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RegexTokenizerImplTest {

    private RegexTokenizerImpl tokenizer;

    private static final String TEXT_TO_PARSE = "Hello 864, world! 123";
    private static final Token[] PARSED_TEXT = generateParsedText();

    private static Token[] generateParsedText() {
        Token word1 = new Word(0, 4, TokensEnum.WORD, "Hello");
        Token number1 = new Number(6, 8, TokensEnum.NUMBER, "123");
        Token punctuation1 = new Punctuation(9, 9, TokensEnum.PUNCTUATION, ",");
        Token word2 = new Word(11, 15, TokensEnum.WORD, "world");
        Token punctuation2 = new Punctuation(16, 16, TokensEnum.PUNCTUATION, "!");
        Token number2 = new Number(18, 20, TokensEnum.NUMBER, "123");

        Token[] result = {word1, number1, punctuation1, word2, punctuation2, number2};

        return result;
    }

    @org.junit.Before
    public void setUp() throws Exception {
        tokenizer = new RegexTokenizerImpl();
    }

    @org.junit.Test
    public void parse() throws Exception {
        Token[] expected = PARSED_TEXT;
        Token[] actual = tokenizer.parse(TEXT_TO_PARSE);
        Arrays.equals(actual, expected);
    }
}