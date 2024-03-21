package tech.kitucode.spring.tdd.controller;

import org.springframework.web.bind.annotation.*;
import tech.kitucode.spring.tdd.domain.Friend;
import tech.kitucode.spring.tdd.service.FriendService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FriendController {
    private final FriendService friendService;

    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @PostMapping("/friends")
    public Friend save(@RequestBody Friend friend) {
        return friendService.save(friend);
    }

    @GetMapping("/friends")
    public List<Friend> getAll() {
        return friendService.findAll();
    }

    @DeleteMapping("/friends/{id}")
    public void delete(@PathVariable Long id) {
        friendService.delete(id);
    }
}
