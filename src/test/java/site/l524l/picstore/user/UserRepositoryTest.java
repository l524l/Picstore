package site.l524l.picstore.user;

import java.util.UUID;

import org.assertj.core.internal.bytebuddy.utility.RandomString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTest {
	@Autowired
	private UserRepository repository;

	@Test
	void saveTest() {
		DefailtUserBuilder builder = new DefailtUserBuilder();
		Role r1 = new Role("test_admin");
		Role r2 = new Role("test_user");
		
		r1.addAuthority(new RoleAuthority("read_asd"));
		r1.addAuthority(new RoleAuthority("write_asd"));
		
		r2.addAuthority(new RoleAuthority("read_asd"));
		r2.addAuthority(new RoleAuthority("write_asd"));
		
		User user = builder.id(UUID.randomUUID())
			.username(RandomString.make(7))
			.password(RandomString.make(7))
			.addRole(r1)
			.addRole(r2)
			.build();
		
		repository.save(user);
		
		Assertions.assertEquals(repository.findById(user.getId()).get().getUsername(),  user.getUsername());
	}

}
