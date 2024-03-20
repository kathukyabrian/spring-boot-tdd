package tech.kitucode.spring.tdd.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tech.kitucode.spring.tdd.domain.Friend;
import tech.kitucode.spring.tdd.domain.enumerations.Gender;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FriendRepositoryTest {
    @Autowired
    FriendRepository friendRepository;

    @Test
    public void testCreateReadDelete() {
        Friend friend = new Friend("Brian", "brian@gmail.com", "254712345678", Gender.MALE);

        friendRepository.save(friend);

        Iterable<Friend> friends = friendRepository.findAll();
        Assertions.assertThat(friends).extracting(Friend::getName).containsOnly("Brian");

        friendRepository.deleteAll();
        Assertions.assertThat(friendRepository.findAll()).isEmpty();
    }
}
