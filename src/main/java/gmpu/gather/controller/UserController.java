package gmpu.gather.controller;

import gmpu.gather.model.Note;
import gmpu.gather.model.User;
import gmpu.gather.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    @PostMapping
    public Mono<User> addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping
    public Flux<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public Mono<User> findUserById(@PathVariable Integer userId){
        return userRepository.findById(userId);
    }
}
