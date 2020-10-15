package co.domi.clase10.model;

public class Chat {
    private String userID1;
    private String userID2;
    private String chatID;

    public Chat() {
    }

    public Chat(String userID1, String userID2, String chatID) {
        this.userID1 = userID1;
        this.userID2 = userID2;
        this.chatID = chatID;
    }

    public String getUserID1() {
        return userID1;
    }

    public void setUserID1(String userID1) {
        this.userID1 = userID1;
    }

    public String getUserID2() {
        return userID2;
    }

    public void setUserID2(String userID2) {
        this.userID2 = userID2;
    }

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }
}
