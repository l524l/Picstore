package site.l524l.picstore.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DefailtUserBuilder implements UserBuilder {
	
	private UUID id;
	
	private String username;
	
	private String password;
	
	private List<Role> roles = new ArrayList<Role>();
	
	private boolean accountNonExpired = true;
	
	private boolean accountNonLocked = true;
	
	private boolean credentialsNonExpired = true;
	
	private boolean enabled = true;

	
	@Override
	public UserBuilder id(UUID id) {
		this.id = id;
		return this;
	}

	@Override
	public UserBuilder username(String username) {
		this.username = username;
		return this;
	}

	@Override
	public UserBuilder password(String password) {
		this.password = password;
		return this;
	}

	@Override
	public UserBuilder roles(List<Role> roles) {
		this.roles = roles;
		return this;
	}

	@Override
	public UserBuilder accountNonExpired(boolean value) {
		this.accountNonExpired = value;
		return this;
	}

	@Override
	public UserBuilder accountNonLocked(boolean value) {
		this.accountNonLocked = value;
		return this;
	}

	@Override
	public UserBuilder credentialsNonExpired(boolean value) {
		this.credentialsNonExpired = value;
		return this;
	}

	@Override
	public UserBuilder enabled(boolean value) {
		this.enabled = value;
		return this;
	}
	
	@Override
	public UserBuilder addRole(Role role) {
		roles.add(role);
		return this;
	}

	@Override
	public User build() {
		if (id == null | username == null | password == null) {
			throw new RuntimeException();
		}
		
		User user = new User();
		
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setRoles(roles);
		user.setAccountNonExpired(accountNonExpired);
		user.setAccountNonLocked(accountNonLocked);
		user.setCredentialsNonExpired(credentialsNonExpired);
		user.setEnabled(enabled);	
		
		return user;
	}
}
