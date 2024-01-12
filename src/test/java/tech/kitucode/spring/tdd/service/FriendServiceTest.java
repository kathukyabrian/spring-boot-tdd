package tech.kitucode.spring.tdd.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.kitucode.spring.tdd.domain.Friend;
import tech.kitucode.spring.tdd.domain.enumerations.Gender;
import tech.kitucode.spring.tdd.repository.FriendRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FriendServiceTest {
    @InjectMocks
    FriendService friendService;

    @Mock
    FriendRepository friendRepository;

    @Test
    void testFindAllFriends() {
        List<Friend> friends = new ArrayList<>();
        Friend friendOne = new Friend("John", "john@gmail.com", "0712436587", Gender.FEMALE);
        Friend friendTwo = new Friend("Doe", "doe@gmail.com", "0712345678", Gender.MALE);

        friends.add(friendOne);
        friends.add(friendTwo);

        when(friendRepository.findAll()).thenReturn(friends);

        List<Friend> friendList = friendService.findAll();
        assertEquals(2, friendList.size());
        verify(friendRepository, times(1)).findAll();
    }
}
