package procesos.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import procesos.inventario.model.User;
import procesos.inventario.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("users")
    public User create (@RequestBody User user){
        return userService.createUser(user);
    }
    @GetMapping("users/{id}")

    public User getUserById(@PathVariable Long id){
      return userService.getUserById(id);
    }

    @PutMapping("users/{id}")
    public User update(@RequestBody User user,@PathVariable Long id){
        return userService.updateUser(user,id);
    }

    @DeleteMapping("user/{id}")
    public Boolean delete(@PathVariable Long id){
        return userService.deleteUserById(id);
    }

}