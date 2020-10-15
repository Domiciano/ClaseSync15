package co.domi.clase10.activities;

import androidx.appcompat.app.AppCompatActivity;
import co.domi.clase10.R;
import co.domi.clase10.model.Message;
import co.domi.clase10.model.User;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {


    private EditText msgET;
    private Button sendBtn;
    private TextView messagesTV;
    private User myUser;
    private User userClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        msgET = findViewById(R.id.msgET);
        sendBtn = findViewById(R.id.sendBtn);
        messagesTV = findViewById(R.id.messagesTV);

        myUser = (User) getIntent().getExtras().getSerializable("myUser");
        userClicked = (User) getIntent().getExtras().getSerializable("userClicked");

        sendBtn.setOnClickListener(this);

        Toast.makeText(this, "Usted esta en la conversacion de " + myUser.getUsername() + " con " + userClicked.getUsername(), Toast.LENGTH_LONG).show();


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sendBtn:
                String msg = msgET.getText().toString();
                Message message = new Message(UUID.randomUUID().toString(), msg, myUser.getId());
                break;
        }
    }
}