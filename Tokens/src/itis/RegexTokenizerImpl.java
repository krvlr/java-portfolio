package itis;

import java.util.regex.*;

public class RegexTokenizerImpl implements Tokenizer {

    @Override
    public Token[] parse(String text) {

        Token[] tokens = new Token[text.length()/2];

        Pattern wordPattern = Pattern.compile("\\s*[a-zA-Z]+\\s*");
        Matcher wordMatcher = wordPattern.matcher(text);

        int count = 0;
        while (wordMatcher.find()){
            tokens[count] = new Word();
            tokens[count].setStartPosition(wordMatcher.start());
            tokens[count].setStopPosition(wordMatcher.end());
            tokens[count].setContent(wordMatcher.group());
            count++;
        }

        Pattern numberPattern = Pattern.compile("\\s*[\\d]+\\s*");
        Matcher numberMatcher = numberPattern.matcher(text);

        while (numberMatcher.find()){
            tokens[count] = new Number();
            tokens[count].setStartPosition(numberMatcher.start());
            tokens[count].setStopPosition(numberMatcher.end());
            tokens[count].setContent(numberMatcher.group());
            count++;
        }

        Pattern punctuationPattern = Pattern.compile("[,.!?]");
        Matcher punctuationMatcher = punctuationPattern.matcher(text);

        while (punctuationMatcher.find()){
            tokens[count] = new Punctuation();
            tokens[count].setStartPosition(punctuationMatcher.start());
            tokens[count].setStopPosition(punctuationMatcher.end());
            tokens[count].setContent(punctuationMatcher.group());
            count++;
        }

        return tokens;
    }
}
