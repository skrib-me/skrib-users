package me.skrib.users.web;

import me.skrib.users.model.User;
import me.skrib.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<Void> saveMessage(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(
            path = "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<User> getUser(
            @PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<User> getUserByOktaId(
            @RequestParam(name = "oktaId") String oktaId) {
        return ResponseEntity.ok(userService.getUserByOktaId(oktaId));
    }

    @GetMapping(
            path = "/me",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    @PreAuthorize("#oauth2.hasScope('openid')")
    public ResponseEntity<User> me() {
        return ResponseEntity.ok(userService.me());
    }
}
