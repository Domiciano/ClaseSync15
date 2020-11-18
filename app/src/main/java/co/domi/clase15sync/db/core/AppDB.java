package co.domi.clase15sync.db.core;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import co.domi.clase15sync.app.AppConfig;
import co.domi.clase15sync.db.dao.TaskDAO;
import co.domi.clase15sync.db.entity.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDB extends RoomDatabase {

    private static AppDB instance;

    //Patron singleton
    public static AppDB getInstance() {
        if (instance == null) {
            instance = Room.databaseBuilder(AppConfig.getContext(),
                    AppDB.class, "tasksDB").allowMainThreadQueries().build();
        }
        return instance;
    }

    //Registramos los daos como métodos abstractos de la base de datos
    public abstract TaskDAO taskDao();

}
