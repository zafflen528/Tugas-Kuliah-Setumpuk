package projectakhir.note.app.core.repository;


import projectakhir.note.app.model.Login;
import projectakhir.note.app.model.Note;

import java.util.List;

public interface INoteRepository {

    Login getAccount(String email, String password);
    boolean isEmailAlreadyExist(String email);
    boolean isNameAlreadyExist(String name);
    void register(String email, String password, String name);

    void insert(String title, String content, String date, String author);
    void delete(String id);
    void update(String id, String title, String content, String date, String author);
    List<Note> getAllNotes(String author);
    Note getSelectedNote(String id);
    boolean isIdExist(String id, String author);
}
