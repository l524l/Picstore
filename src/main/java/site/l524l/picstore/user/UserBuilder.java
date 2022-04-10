package site.l524l.picstore.user;

import java.util.List;
import java.util.UUID;

public interface UserBuilder {
	
	UserBuilder id(UUID uuid);
	
	UserBuilder username(String username);
	
	UserBuilder password(String password);
	
	UserBuilder roles(List<Role> roles);
	
	UserBuilder accountNonExpired(boolean value);
	
	UserBuilder accountNonLocked(boolean value);
	
	UserBuilder credentialsNonExpired(boolean value);
	
	UserBuilder enabled(boolean value);
	
	UserBuilder addRole(Role role);
	
	User build();

}
