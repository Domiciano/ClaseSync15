package co.domi.clase15sync.activities;

import androidx.appcompat.app.AppCompatActivity;

import co.domi.clase15sync.R;
import co.domi.clase15sync.db.core.AppDB;
import co.domi.clase15sync.db.entity.Task;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private EditText newTaskET;
    private Button commitBtn;

    //Conjuto de variables para la lista To do
    private ListView toDoTaskList;
    private ArrayList<Task> toDoTasks;
    private ArrayAdapter<Task> toDoTaskAdapter;

    //Conjunto de variables para la lista done
    private ListView doneTaskList;
    private ArrayList<Task> doneTasks;
    private ArrayAdapter<Task> doneTaskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newTaskET = findViewById(R.id.newTaskET);
        commitBtn = findViewById(R.id.commitBtn);
        toDoTaskList = findViewById(R.id.toDoTaskList);
        doneTaskList = findViewById(R.id.doneTaskList);

        toDoTasks = new ArrayList<>();
        toDoTaskAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, toDoTasks);
        toDoTaskList.setAdapter(toDoTaskAdapter);

        doneTasks = new ArrayList<>();
        doneTaskAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, doneTasks);
        doneTaskList.setAdapter(doneTaskAdapter);

        commitBtn.setOnClickListener(this::addTask);
        toDoTaskList.setOnItemClickListener(this::moveTaskToDone);
        doneTaskList.setOnItemClickListener(this::moveTaskToToDo);
        toDoTaskList.setOnItemLongClickListener(this::deleteTaskFromToDo);
        doneTaskList.setOnItemLongClickListener(this::deleteTaskFromDone);

        fillToDoList();
        fillDoneList();
    }

    private void addTask(View view) {
        Task task = new Task(
                UUID.randomUUID().toString(),
                newTaskET.getText().toString(),
                new Date().getTime(),
                false
        );
        AppDB.getInstance().taskDao().insert(task);
        fillToDoList();
        fillDoneList();
    }

    private void fillToDoList() {
        List<Task> tasks = AppDB.getInstance().taskDao().getAll();
        toDoTasks.clear();
        for(Task task : tasks){
            if(!task.isDone()){
                toDoTasks.add(task);
            }
        }
        toDoTaskAdapter.notifyDataSetChanged();
    }

    private void fillDoneList() {
        List<Task> tasks = AppDB.getInstance().taskDao().getAll();
        doneTasks.clear();
        for(Task task : tasks){
            if(task.isDone()){
                doneTasks.add(task);
            }
        }
        doneTaskAdapter.notifyDataSetChanged();
    }

    private void moveTaskToDone(AdapterView<?> adapterView, View view, int position, long l) {
        Task selectedTask = toDoTasks.get(position);
        selectedTask.setDone(true);
        AppDB.getInstance().taskDao().insert(selectedTask);
        fillToDoList();
        fillDoneList();
    }
    private void moveTaskToToDo(AdapterView<?> adapterView, View view, int position, long l) {
        Task selectedTask = doneTasks.get(position);
        selectedTask.setDone(false);
        AppDB.getInstance().taskDao().insert(selectedTask);
        fillToDoList();
        fillDoneList();
    }

    private boolean deleteTaskFromToDo(AdapterView<?> adapterView, View view, int position, long l) {
        Task selectedTask = toDoTasks.get(position);
        return true;
    }

    private boolean deleteTaskFromDone(AdapterView<?> adapterView, View view, int position, long l) {
        Task selectedTask = doneTasks.get(position);
        return true;
    }

}