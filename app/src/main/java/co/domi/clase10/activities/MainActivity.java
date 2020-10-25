package co.domi.clase10.activities;

import androidx.appcompat.app.AppCompatActivity;
import co.domi.clase10.R;
import co.domi.clase10.comm.Actions;
import co.domi.clase10.events.OnRegisterListener;
import co.domi.clase10.model.User;
import co.domi.clase10.util.NotificationUtil;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button loginBtn;
    private EditText usernameET;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.loginBtn);
        usernameET = findViewById(R.id.usernameET);

        loginBtn.setOnClickListener(this);

        db = FirebaseFirestore.getInstance();



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginBtn:
                String username = usernameET.getText().toString();
                User user = new User(UUID.randomUUID().toString(), username);

                //Saber si el usuario ya estaba registrado
                CollectionReference usersRef = db.collection("users");
                Query query = usersRef.whereEqualTo("username", username);
                query.get().addOnCompleteListener(
                        task -> {
                            if (task.isSuccessful()) {

                                if (task.getResult().size() > 0) {
                                    for(QueryDocumentSnapshot document : task.getResult()){
                                        User dbUser = document.toObject(User.class);
                                        goToUserListActivity(dbUser);
                                        break;
                                    }
                                } else {
                                    db.collection("users").document(user.getId()).set(user);
                                    goToUserListActivity(user);
                                }
                            }
                        }
                );


                break;
        }
    }


    public void goToUserListActivity(User user) {
        Intent i = new Intent(this, UserListActivity.class);
        i.putExtra("myUser", user);
        startActivity(i);
    }
}