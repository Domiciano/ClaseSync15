package co.domi.clase10.events;

import java.util.ArrayList;

import co.domi.clase10.model.User;

public interface OnUserListListener {
    void onGetUsers(ArrayList<User> userList);
}
