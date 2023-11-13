package gmpu.gather.repository;
import gmpu.gather.model.Note;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface NoteRepository extends ReactiveCrudRepository<Note, Integer> {
    //this will find the notes by userId
    Flux<Note> findByUserId(Integer userId);
    //this will find the notes by bookId
    Flux<Note> findBySourceId(Integer sourceId);
}

