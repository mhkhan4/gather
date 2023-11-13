package gmpu.gather.controller;

import gmpu.gather.model.Note;
import gmpu.gather.repository.NoteRepository;
import gmpu.gather.service.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/notes")
@AllArgsConstructor
public class NoteController {

    private final NoteRepository noteRepository;
    private final NoteService noteService;

    @GetMapping("/{userId}")
    public Flux<Note> getNotesByUserId(@PathVariable Integer userId) {
        return noteRepository.findByUserId(userId);
    }

    @GetMapping("/{sourceId}")
    public Flux<Note> getNotesBySourceId(@PathVariable Integer sourceId) {
        return noteRepository.findBySourceId(sourceId);
    }

    @PostMapping
    public Mono<Note> addNote(@RequestBody Note note){
        return noteService.createNote(note);
    }
}
