package site.l524l.picstore.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {
	
	User findByUsername(String username);
}
