package projectakhir.note.app.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeForm extends Application {

    private Text textAuthor;

    private Button btnNewNote;
    private Button btnAllNotes;
    private Button btnLogout;

    public static String argAccountName;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initButtonNewNote(primaryStage);
        initButtonAllNotes(primaryStage);
        initButtonLogout(primaryStage);
        initTextAuthor();

        VBox vBoxAllButton = new VBox(25, btnNewNote, btnAllNotes, btnLogout);
        vBoxAllButton.setLayoutX(250);
        vBoxAllButton.setLayoutY(135);

        Group root = new Group(textAuthor, vBoxAllButton);
        Scene scene = new Scene(root, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void initTextAuthor() {
        textAuthor = new Text();
        textAuthor.setText("Author: " + argAccountName);
        textAuthor.setX(50);
        textAuthor.setY(50);
        textAuthor.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
    }

    private void initButtonNewNote(Stage stage) {
        btnNewNote = new Button();
        btnNewNote.setText("Add New Note");
        btnNewNote.setPrefSize(200, 75);
        btnNewNote.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                InsertNoteForm insertNoteForm = new InsertNoteForm();
                insertNoteForm.start(stage);
            }
        });
    }

    private void initButtonAllNotes(Stage stage) {
        btnAllNotes = new Button();
        btnAllNotes.setText("All Notes");
        btnAllNotes.setPrefSize(200, 75);
        btnAllNotes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AllNotesForm allNotesForm = new AllNotesForm();
                allNotesForm.start(stage);
            }
        });
    }

    private void initButtonLogout(Stage stage) {
        btnLogout = new Button();
        btnLogout.setText("Logout");
        btnLogout.setPrefSize(200, 75);
        btnLogout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginForm loginForm = new LoginForm();
                loginForm.start(stage);
            }
        });
    }
}