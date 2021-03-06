package sem2.pbo.projectakhir.note.app;

import sem2.pbo.projectakhir.note.app.di.Injection;
import sem2.pbo.projectakhir.note.app.model.Login;
import sem2.pbo.projectakhir.note.app.ui.HomeView;
import sem2.pbo.projectakhir.note.app.ui.LoginView;

public class App {

    private static LoginView loginView = Injection.provideLoginView;
    private static HomeView homeView = Injection.provideHomeView;

    public static void main(String[] args) {

        System.out.println("\t\t\t\tWelcome To Note App\t\t\t\t\t\n");

        Login account = loginView.login();
        String author = account.name();

        homeView.home(author);
    }
}
