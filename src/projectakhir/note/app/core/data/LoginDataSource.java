package projectakhir.note.app.core.data;

import projectakhir.note.app.core.data.login.LoginClient;
import projectakhir.note.app.core.data.login.LoginResponse;

public class LoginDataSource {

    private static LoginDataSource INSTANCE;

    private LoginClient loginClient;

    public static LoginDataSource getInstance(LoginClient loginClient) {
        if (INSTANCE == null)
            INSTANCE = new LoginDataSource(loginClient);
        return INSTANCE;
    }

    public LoginDataSource(LoginClient loginClient) {
        this.loginClient = loginClient;
    }

    public LoginResponse getAccount(String email, String password) {
        return loginClient.getAccount(email, password);
    }

    public boolean isEmailAlreadyExist(String email) {
        return loginClient.isEmailAlreadyExist(email);
    }

    public boolean isNameAlreadyExist(String name) {
        return loginClient.isNameAlreadyExist(name);
    }

    public void register(String email, String password, String name) {
        loginClient.register(email, password, name);
    }
}
