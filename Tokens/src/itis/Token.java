package itis;

public interface Token {

    String getTYPE();

    int getStartPosition();

    void setStartPosition(int startPosition);

    int getStopPosition();

    void setStopPosition(int stopPosition);

    String getContent();

    void setContent(String content);

    String toString();
}
