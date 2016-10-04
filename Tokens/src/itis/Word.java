package itis;

public class Word implements Token{

    final String TYPE = "Word";

    @Override
    public String getTYPE() {
        return TYPE;
    }

    private int startPosition;

    @Override
    public int getStartPosition() {
        return startPosition;
    }

    @Override
    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    private int stopPosition;

    @Override
    public int getStopPosition() {
        return stopPosition;
    }

    @Override
    public void setStopPosition(int stopPosition) {
        this.stopPosition = stopPosition;
    }

    private String content;

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString(){
        return content;
    }
}
