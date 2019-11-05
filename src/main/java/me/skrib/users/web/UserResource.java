package me.skrib.users.web;

import me.skrib.users.model.User;
import me.skrib.users.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
//    @PreAuthorize("#oauth2.hasScope('me.skrib.users.write')")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping(
            path = "/search",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
//    @PreAuthorize("#oauth2.hasScope('me.skrib.users.read')")
    public ResponseEntity<User> search(SearchCriteria criteria) {
        User user = null;
        if (criteria.getId() != null) {
            user = userService.getUser(criteria.getId());
        }
        if (user == null && criteria.getUsername() != null) {
            user = userService.getUser(criteria.getUsername());
        }
        if (user == null && criteria.getOktaId() != null) {
            user = userService.getUserByOktaId(criteria.getOktaId());
        }
        return user != null ? ResponseEntity.ok(user)
                            : ResponseEntity.noContent().build();
    }

    @GetMapping(
            path = "/me",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
//    @PreAuthorize("#oauth2.hasScope('openid')")
    public ResponseEntity<User> me() {
        return ResponseEntity.ok(userService.me());
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<User> getUser(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }
}
