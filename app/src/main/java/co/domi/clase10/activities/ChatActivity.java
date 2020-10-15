package co.domi.clase10.activities;

import androidx.appcompat.app.AppCompatActivity;
import co.domi.clase10.R;
import co.domi.clase10.model.User;

import android.os.Bundle;
import android.widget.Toast;

public class ChatActivity extends AppCompatActivity {

    private User myUser;
    private User userClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        myUser = (User) getIntent().getExtras().getSerializable("myUser");
        userClicked = (User) getIntent().getExtras().getSerializable("userClicked");

        Toast.makeText(this, "Usted esta en la conversacion de " + myUser.getUsername() + " con " + userClicked.getUsername(), Toast.LENGTH_LONG).show();
    }
}