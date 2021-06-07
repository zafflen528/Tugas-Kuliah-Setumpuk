package projectakhir.note.app.di;


import projectakhir.note.app.core.data.LoginDataSource;
import projectakhir.note.app.core.data.NoteDataSource;
import projectakhir.note.app.core.data.login.LoginBuilder;
import projectakhir.note.app.core.data.login.LoginClient;
import projectakhir.note.app.core.data.note.NoteBuilder;
import projectakhir.note.app.core.data.note.NoteDao;
import projectakhir.note.app.core.repository.INoteRepository;
import projectakhir.note.app.core.repository.NoteRepository;

public class Injection {

    //Login
    public static LoginClient provideLoginDB = LoginBuilder.getInstance();
    public static LoginDataSource provideLoginDataSource = LoginDataSource.getInstance(provideLoginDB);

    //Note
    public static NoteDao provideNoteDB = NoteBuilder.getInstance();
    public static NoteDataSource provideNoteDataSource = NoteDataSource.getInstance(provideNoteDB);

    //Repository
    public static INoteRepository provideNoteRepository = NoteRepository.getInstance(provideLoginDataSource, provideNoteDataSource);

}