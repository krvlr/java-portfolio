package ru.itis.models;

public class Chat {

    private int chatId;
    private String name;
    private int ownerId;

    public Chat(){}

    public Chat(int chatId, String name, int ownerId) {
        this.chatId = chatId;
        this.name = name;
        this.ownerId = ownerId;
    }

    public int getChatId() {
        return chatId;
    }

    public String getName() {
        return name;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public static Builder newBuilder() {
        return new Chat().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setChatId(int chatId) {
            Chat.this.chatId = chatId;
            return this;
        }

        public Builder setName(String name) {
            Chat.this.name = name;
            return this;
        }

        public Builder setOwnerId(int ownerId) {
            Chat.this.ownerId = ownerId;
            return this;
        }

        public Chat build() {
            return Chat.this;
        }
    }
}
