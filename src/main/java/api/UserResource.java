package api;

import modal.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping(value = "user")
public class UserResource {
    @Autowired
    private UserService userService;

    //  create new User
    @PostMapping("/save")
    public String saveUserDetails(@RequestBody User user){
        return userService.createUser(user);
    }

    //  get all users
    @CrossOrigin
    @GetMapping("/get")
    private List<User> getAllPost() throws ExecutionException, InterruptedException {
        return userService.getAllUser();
    }
}
