package itis.Solution;
import itis.Tokens.*;
import itis.Tokens.Number;

public class SimpleTokenizerImpl implements Tokenizer {

    private TokensEnum getCharType(char c) {
        if (Character.isLetter(c)) {
            return TokensEnum.WORD;
        } else if (Character.isDigit(c)) {
            return TokensEnum.NUMBER;
        } else if (Character.isWhitespace(c)) {
            return TokensEnum.WHITESPACE;
        } else return TokensEnum.PUNCTUATION;
    }

    @Override
    public Token[] parse(String text) {

        char[] charsText = text.toCharArray();

        Token[] tokens = new Token[charsText.length / 2];
        int countTokens = 0;

        TokensEnum previousCharacterType = null;

        int startPosition = 0;
        int stopPosition = 0;
        String content = "";

        for (int i = 0; i < charsText.length; i++) {
            if (getCharType(charsText[i]) == TokensEnum.PUNCTUATION) {
                tokens[countTokens] = new Punctuation(i, i, TokensEnum.PUNCTUATION, String.valueOf(charsText[i]));
                countTokens++;
            } else if (getCharType(charsText[i]) == TokensEnum.WORD) {
                content += charsText[i];
                if (previousCharacterType == null || previousCharacterType != TokensEnum.WORD) {
                    startPosition = i;
                } else if ((i == text.length() - 1) || ((i < text.length() - 1)
                        && getCharType(text.charAt(i + 1)) != TokensEnum.WORD)) {
                    stopPosition = i;
                    tokens[countTokens] = new Word(startPosition, stopPosition, TokensEnum.WORD, content);
                    content = "";
                    countTokens++;
                }
            } else if (getCharType(charsText[i]) == TokensEnum.NUMBER) {
                content += charsText[i];
                if (previousCharacterType == null || previousCharacterType != TokensEnum.NUMBER) {
                    startPosition = i;
                } else if ((i == text.length() - 1) || ((i < text.length() - 1)
                        && getCharType(text.charAt(i + 1)) != TokensEnum.NUMBER)) {
                    stopPosition = i;
                    tokens[countTokens] = new Number(startPosition, stopPosition, TokensEnum.NUMBER, content);
                    content = "";
                    countTokens++;
                }
            }
            previousCharacterType = getCharType(charsText[i]);
        }
        return tokens;
    }
}
