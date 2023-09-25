package cl.musolutions.muclothes.repository;

import cl.musolutions.muclothes.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmail(String email);
}
