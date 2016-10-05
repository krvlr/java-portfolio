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

        /*Pattern wordPattern = Pattern.compile("\\s*[a-zA-Z]+\\s*");
        Matcher wordMatcher = wordPattern.matcher(text);

        int count = 0;
        while (wordMatcher.find()){
            tokens[count] = new Word(wordMatcher.start(), wordMatcher.end()-1, TokensEnum.WORD, wordMatcher.group());
            count++;
        }

        Pattern numberPattern = Pattern.compile("\\s*[\\d]+\\s*");
        Matcher numberMatcher = numberPattern.matcher(text);

        while (numberMatcher.find()){
            tokens[count] = new Number(numberMatcher.start(), numberMatcher.end()-1, TokensEnum.NUMBER, numberMatcher.group());
            count++;
        }

        Pattern punctuationPattern = Pattern.compile("[,.!?]");
        Matcher punctuationMatcher = punctuationPattern.matcher(text);

        while (punctuationMatcher.find()){
            tokens[count] = new Punctuation(punctuationMatcher.start(), punctuationMatcher.end()-1, TokensEnum.PUNCTUATION, punctuationMatcher.group());
            count++;
        }*/

        return tokens;
    }
}
