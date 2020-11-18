package co.domi.clase15sync.db.dao;

import android.widget.ListView;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

import co.domi.clase15sync.db.entity.Task;

@Dao
public interface TaskDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Task task);

    @Query("SELECT * FROM tasks")
    List<Task> getAll();
}
