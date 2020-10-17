package co.domi.clase10.model;

public class Message {
    private String id;
    private String body;
    private String authorID;
    private long timestamp;

    public Message() {
    }

    public Message(String id, String body, String authorID, long timestamp) {
        this.id = id;
        this.body = body;
        this.authorID = authorID;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
