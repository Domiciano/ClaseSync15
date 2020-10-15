package co.domi.clase10.events;

import co.domi.clase10.model.User;

public interface OnRegisterListener {
    void onRegisterUser(boolean wasRegistered, User user);
}
