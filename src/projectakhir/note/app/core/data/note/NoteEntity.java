package projectakhir.note.app.core.data.note;

public record NoteEntity(
        String id,
        String title,
        String content,
        String date,
        String author
) {
}