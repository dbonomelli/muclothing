package cl.musolutions.muclothes.services.user;

import cl.musolutions.muclothes.models.User;

public interface UserService {
    User login(String email, String password);
    User register(String email, String password);
}
