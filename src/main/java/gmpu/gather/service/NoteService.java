package gmpu.gather.service;

import gmpu.gather.model.Note;
import gmpu.gather.model.Source;
import gmpu.gather.model.User;
import gmpu.gather.repository.NoteRepository;
import gmpu.gather.repository.SourceRepository;
import gmpu.gather.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final SourceRepository sourceRepository;

    // Inject necessary repositories...

    public Mono<Note> createNote(Note note) {
        return validateAndSave(note);
    }

    private Mono<Note> validateAndSave(Note note) {
        return Mono.zip(
                userRepository.findById(note.getUserId()),
                sourceRepository.findById(note.getSourceId())
            )
            .flatMap(tuple -> {
                User user = tuple.getT1();
                Source source = tuple.getT2();

                if (user == null || source == null) {
                    return Mono.error(new IllegalArgumentException("Both User and Source must be specified to create a Note."));
                }

                // Set additional properties or perform other validation as needed

                return noteRepository.save(note);
            });
    }
}