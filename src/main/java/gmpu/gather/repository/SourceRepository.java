package gmpu.gather.repository;

import gmpu.gather.model.Source;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends ReactiveCrudRepository<Source, Integer> {}