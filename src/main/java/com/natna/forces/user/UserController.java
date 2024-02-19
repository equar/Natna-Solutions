package com.natna.forces.user;
import com.natna.forces.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired
  private IUserService userService;

  @PostMapping("/user")
  public User createUser( @RequestBody User user) {

      User userResponse = userService.addUser(user);
      return new ResponseEntity<>(userResponse, HttpStatus.CREATED).getBody();

  }

  @GetMapping("/users")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/user/{id}")
  public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
      throws ResourceNotFoundException {

    User user = userService.getUserById(userId);

    return ResponseEntity.ok().body(user);
  }

  @PutMapping("/user/{id}")
  public ResponseEntity<User> updateUser(
      @PathVariable(value = "id") Long userId,  @RequestBody User userDetails)
      throws ResourceNotFoundException {

    User updatedUser = userService.updateUser(userId,userDetails);

    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/user/{id}")
  public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId) throws Exception {

    userService.deleteUser(userId);

    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }

  @PutMapping("/user/{id}/status/{status}")
  public Map<String, Boolean> updateUserStatus(
          @PathVariable(value = "id") Long userId,  @PathVariable(value = "status") String status,  @RequestBody User userDetails)
          throws ResourceNotFoundException {

    User updatedUser = userService.updateUserStatus(userId,status);

    Map<String, Boolean> response = new HashMap<>();
    response.put("Success", Boolean.TRUE);

    return response;
  }

}
