package itis;

public class SimpleTokenizerImpl implements Tokenizer {

    private final char SPACE = ' ';

    private char[] letters = {'a','A','b','B','c','C','d','D','e','E','f','F','g','G','h','H','i','I','j','J','k','K','l','L','m','M',
            'n','N','o','O','p','P','q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z'};

    private char[] numbers = {'0','1','2','3','4','5','6','7','8','9'};

    private char[] punctuations = {'.',',','?','!'};

    @Override
    public Token[] parse(String text) {

        char[] charsText = text.toCharArray();

        Token[] tokens = new Token[charsText.length/2];

        int countTokens = 0;

        String content = "";

        boolean tokenIsWord = false, tokenIsNumber = false;

        for (int i = 0; i < charsText.length; i++){
            if (!tokenIsNumber) {
                for (char letter : this.letters) {
                    if (charsText[i] == letter) {
                        if (charsText[i - 1] == this.SPACE) {
                            tokens[countTokens] = new Word();
                            tokens[countTokens].setStartPosition(i);
                            content = "";
                            tokenIsWord = true;
                        }
                        content += charsText[i];
                        if (charsText[i + 1] == this.SPACE) {
                            tokens[countTokens].setStopPosition(i);
                            tokens[countTokens].setContent(content);
                            countTokens++;
                            tokenIsWord = false;
                        }
                        break;
                    }
                }
            }
            if (!tokenIsWord) {
                for(char number : this.numbers) {
                    if (charsText[i] == number) {
                        if (charsText[i - 1] == this.SPACE) {
                            tokens[countTokens] = new Number();
                            tokens[countTokens].setStartPosition(i);
                            content = "";
                            tokenIsNumber = true;
                        }
                        content += charsText[i];
                        if (charsText[i + 1] == this.SPACE) {
                            tokens[countTokens].setStopPosition(i);
                            tokens[countTokens].setContent(content);
                            countTokens++;
                            tokenIsNumber = false;
                        }
                        break;
                    }
                }
            }
            if (!tokenIsWord && !tokenIsNumber) {
                for (char punctuation : this.punctuations) {
                    if (charsText[i] == punctuation) {
                        if (charsText[i - 1] == this.SPACE) {
                            tokens[countTokens] = new Punctuation();
                            tokens[countTokens].setStartPosition(i);
                            tokens[countTokens].setStopPosition(i);
                            content = "";
                            content += charsText[i];
                            tokens[countTokens].setContent(content);
                            countTokens++;
                        }
                        break;
                    }
                }
            }
        }
        return tokens;
    }
}
