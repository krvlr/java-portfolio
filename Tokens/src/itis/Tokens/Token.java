package itis.Tokens;

public interface Token {

    TokensEnum getType();

    int getStartPosition();

    int getStopPosition();

    String getContent();
}
