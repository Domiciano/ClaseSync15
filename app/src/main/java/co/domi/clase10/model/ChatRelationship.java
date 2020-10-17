package co.domi.clase10.model;

public class ChatRelationship {
    //FK
    private String chatID;

    //Metadata
    private String contactID;
    private String contactName;


    public ChatRelationship() {
    }

    public ChatRelationship(String chatID, String contactID, String contactName) {
        this.chatID = chatID;
        this.contactID = contactID;
        this.contactName = contactName;
    }

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public String getContactID() {
        return contactID;
    }

    public void setContactID(String contactID) {
        this.contactID = contactID;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }
}
