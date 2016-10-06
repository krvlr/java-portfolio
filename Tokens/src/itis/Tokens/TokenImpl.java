package itis.Tokens;

public class TokenImpl implements Token {

    protected TokensEnum type;

    protected int startPosition;

    protected int stopPosition;

    protected String content;

    @Override
    public TokensEnum getType() {
        return this.type;
    }

    @Override
    public int getStartPosition() {
        return startPosition;
    }

    @Override
    public int getStopPosition() {
        return stopPosition;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "\nStart: " + this.startPosition + ", end: " + this.stopPosition + ", content: " + this.content + "\n";
    }
}
