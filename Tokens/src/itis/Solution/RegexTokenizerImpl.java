package itis.Solution;

import itis.Tokens.*;
import itis.Tokens.Number;

import java.util.regex.*;

public class RegexTokenizerImpl implements Tokenizer {

    @Override
    public Token[] parse(String text) {

        Token[] tokens = new Token[text.length()/2];

        Pattern pattern = Pattern.compile("(\\s*[a-zA-Z]+\\s*)|(\\s*[\\d]+\\s*)|(\\s*[,.!?]\\s*)");
        Matcher matcher = pattern.matcher(text);

        int count = 0;
        while (matcher.find()){
            if (Character.isLetter(matcher.group().toCharArray()[0])){
                tokens[count] = new Word(matcher.start(), matcher.end()-1, TokensEnum.WORD, matcher.group());
            }else if (Character.isDigit(matcher.group().toCharArray()[0])){
                tokens[count] = new Number(matcher.start(), matcher.end()-1, TokensEnum.NUMBER, matcher.group());
            }else if ((matcher.group().toCharArray()[0]=='.')||(matcher.group().toCharArray()[0]==',')||
                    (matcher.group().toCharArray()[0]=='!')||(matcher.group().toCharArray()[0]=='?')){
                tokens[count] = new Punctuation(matcher.start(), matcher.end()-1, TokensEnum.PUNCTUATION, matcher.group());
            }
            count++;
        }
        return tokens;
    }
}
