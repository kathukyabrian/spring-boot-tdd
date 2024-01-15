package tech.kitucode.spring.tdd.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tech.kitucode.spring.tdd.domain.Friend;
import tech.kitucode.spring.tdd.repository.FriendRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FriendServiceTest {
    @InjectMocks
    FriendService friendService;

    @Mock
    FriendRepository friendRepository;

    @Test
    void testFindAllFriends() {
        List<Friend> friends = Mockito.mock(List.class);
        when(friendRepository.findAll()).thenReturn(friends);
        List<Friend> friendList = friendService.findAll();
        assertFalse(friendList.isEmpty());
        verify(friendRepository, times(1)).findAll();
    }

    @Test
    void testSaveFriend() {
        Friend friend = Mockito.mock(Friend.class);
        when(friendRepository.save(Mockito.any(Friend.class))).thenReturn(friend);
        Friend savedFriend = friendService.save(friend);
        assertNotNull(savedFriend);
    }

    @Test
    void testFindFriendById(){
        Long id = 1L;
        Friend mockFriend = Mockito.mock(Friend.class);
        when(friendRepository.findById(id)).thenReturn(Optional.of(mockFriend));
        Optional<Friend> result = friendService.findOne(id);

        assertTrue(result.isPresent());
        assertSame(mockFriend, result.get());
    }

    @Test
    void testFriendDoesNotExist(){
        Long id = 2L;
        when(friendRepository.findById(id)).thenReturn(Optional.empty());
        Optional<Friend> result = friendService.findOne(id);

        assertFalse(result.isPresent());
    }
}
