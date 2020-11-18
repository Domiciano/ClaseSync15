package co.domi.clase15sync.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class Task {

    @NonNull
    @PrimaryKey
    private String id;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "date")
    private long date;
    @ColumnInfo(name = "done")
    private boolean done;

    public Task() {
    }

    public Task(String id, String description, long date, boolean done) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    @NonNull
    @Override
    public String toString() {
        return this.description;
    }
}
