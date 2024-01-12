package tech.kitucode.spring.tdd.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import tech.kitucode.spring.tdd.domain.Friend;
import tech.kitucode.spring.tdd.repository.FriendRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FriendService {
    private final FriendRepository friendRepository;
    private final Logger log = LoggerFactory.getLogger(FriendService.class);

    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public Friend save(Friend friend) {
        log.debug("Request to save friend: {}", friend);

        return friendRepository.save(friend);
    }

    public Optional<Friend> findOne(Long id) {
        log.debug("Request to find friend with id : {}", id);

        return friendRepository.findById(id);
    }

    public List<Friend> findAll() {
        log.debug("Request to find all friends");

        return friendRepository.findAll();
    }

    public void delete(Long id) {

        friendRepository.deleteById(id);
    }
}
