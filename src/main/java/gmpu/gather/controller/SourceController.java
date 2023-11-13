package gmpu.gather.controller;

import gmpu.gather.model.Source;
import gmpu.gather.repository.SourceRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/source")
@AllArgsConstructor
public class SourceController {
    private final SourceRepository sourceRepository;

    @PostMapping
    public Mono<Source> addSource(@RequestBody Source source){
        return sourceRepository.save(source);
    }

    @GetMapping
    public Flux<Source> getAllSource(){
        return sourceRepository.findAll();
    }

    @GetMapping("/{sourceId}")
    public Mono<Source> findSourceById(@PathVariable Integer sourceId){
        return sourceRepository.findById(sourceId);
    }
}
