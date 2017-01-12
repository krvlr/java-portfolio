package ru.itis.models;

public class Message {

    private int messageId;
    private String text;
    private int chatId;
    private int userId;

    public Message(){}

    public Message(int messageId, String text, int chatId, int userId) {
        this.messageId = messageId;
        this.text = text;
        this.chatId = chatId;
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public String getText() {
        return text;
    }

    public int getChatId() {
        return chatId;
    }

    public int getUserId() {
        return userId;
    }

    public static Builder newBuilder() {
        return new Message().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setMessageId(int messageId) {
            Message.this.messageId = messageId;
            return this;
        }

        public Builder setText(String text) {
            Message.this.text = text;
            return this;
        }

        public Builder setChatId(int chatId) {
            Message.this.chatId = chatId;
            return this;
        }

        public Builder setUserId(int userId) {
            Message.this.userId = userId;
            return this;
        }

        public Message build() {
            return Message.this;
        }
    }
}
