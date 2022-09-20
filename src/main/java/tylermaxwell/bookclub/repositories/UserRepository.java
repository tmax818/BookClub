package tylermaxwell.bookclub.repositories;

import org.springframework.data.repository.CrudRepository;
import tylermaxwell.bookclub.models.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
