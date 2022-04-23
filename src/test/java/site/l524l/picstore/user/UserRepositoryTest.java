package site.l524l.picstore.user;

import java.util.UUID;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class UserRepositoryTest {
	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	void saveTest() {
		DefailtUserBuilder builder = new DefailtUserBuilder();
		Role r1 = new Role("test_admin");
		Role r2 = new Role("test_user");
		
		User user = builder.id(UUID.randomUUID())
			.username(RandomString.make(7))
			.password("test")
			.addRole(r1)
			.addRole(r2)
			.build();
		
		repository.save(user);
		
		Assertions.assertEquals(repository.findById(user.getId()).get().getUsername(),  user.getUsername());
	}

}
