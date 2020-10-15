package co.domi.clase10.activities;

import androidx.appcompat.app.AppCompatActivity;
import co.domi.clase10.R;
import co.domi.clase10.comm.Actions;
import co.domi.clase10.events.OnRegisterListener;
import co.domi.clase10.model.User;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnRegisterListener {

    private Button loginBtn;
    private EditText usernameET;
    private Actions actions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        usernameET = findViewById(R.id.usernameET);

        loginBtn.setOnClickListener(this);
        actions = new Actions();
        actions.setOnRegisterListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.loginBtn:
                String username = usernameET.getText().toString();
                actions.registerUserIfNotExists(
                        new User(UUID.randomUUID().toString(), username)
                );
                break;
        }
    }

    @Override
    public void onRegisterUser(boolean wasRegistered, User user) {
        runOnUiThread(
                ()->{
                    Intent i = new Intent(this, UserListActivity.class);
                    i.putExtra("myUser", user);
                    startActivity(i);
                }
        );
    }
}