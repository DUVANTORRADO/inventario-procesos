package procesos.inventario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import procesos.inventario.model.User;
import procesos.inventario.repositorio.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    public User updateUser(User user, long id){
        if (userRepository.existsById(id)){
           User userBd = userRepository.findById(id).get();
           userBd.setFirstName(user.getFirstName());
            userBd.setAddress(user.getAddress());
            userBd.setEmail(user.getEmail());
           userBd.setLastName(user.getLastName());
           userBd.setPhone(user.getPhone());
           return userRepository.save(userBd);
        }
        return null;
    }

    public Boolean deleteUserById(Long id){
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public List<User> findAllUsers(){
        return (List<User>) userRepository.findAll();
    }
}




























