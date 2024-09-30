package Main.main.cat.boscdelacoma.newpackage;

import Main.main.cat.boscdelacoma.newpackage.User;
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> registeredUsers;

    public UserService() {
        this.registeredUsers = new HashMap<>();
    }

    public boolean registerUser(String username, String password) {
        if (registeredUsers.containsKey(username)) {
            return false;
        }
        registeredUsers.put(username, new User(username, password));
        return true;
    }

    public boolean authenticate(String username, String password) {
        User user = registeredUsers.get(username);
        return user != null && user.login(password);
    }
}

