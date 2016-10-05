package itis.Tokens;

public class Number extends TokenImpl {

    public Number(int startPosition, int stopPosition, TokensEnum type, String content) {
        this.startPosition = startPosition;
        this.stopPosition = stopPosition;
        this.type = type;
        this.content = content;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || !this.getClass().equals(object.getClass())) {
            return false;
        } else {
            Number that = (Number)object;
            return this.startPosition == that.startPosition
                    && this.stopPosition == that.stopPosition
                    && this.content.equals(that.content)
                    && this.type.equals(that.type);
        }
    }
}
