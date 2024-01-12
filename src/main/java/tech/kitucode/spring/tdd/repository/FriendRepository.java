package tech.kitucode.spring.tdd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.kitucode.spring.tdd.domain.Friend;

public interface FriendRepository extends JpaRepository<Friend, Long> {
}
