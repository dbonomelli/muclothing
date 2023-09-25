package cl.musolutions.muclothes.services.user;

import cl.musolutions.muclothes.models.User;
import cl.musolutions.muclothes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User login(String email, String password) {
        User findUser = userRepository.findByEmail(email);
        if(findUser != null){
            if(findUser.getEmail().equals(email) && findUser.getPassword().equals(password)){
                return findUser;
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    @Override
    public User register(String email, String password) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setPassword(password);
        userRepository.save(newUser);

        return newUser;
    }
}
