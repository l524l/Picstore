package site.l524l.picstore.user;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import site.l524l.picstore.objects.RegisterRequest;

@Service
public class UserService {
	
	private final UserRepository repository;
	private final PasswordEncoder passwordEncoder;
	
	
	public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
		this.repository = repository;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	public User get(UUID id) {
		return repository.findById(id)
				.orElseThrow(RuntimeException::new);
	}
	
	public User get(String username) {
		return repository.findByUsername(username)
		.orElseThrow(RuntimeException::new);
	}
	
	public void enable(User user) {
		enable(user.getId());
	}
	
	public void enable(UUID id) {
		User usr = get(id);
		
		usr.setEnabled(true);
		
		save(usr);
	}
	
	public void enable(String username) {
		User usr = get(username);
		
		usr.setEnabled(true);
		
		save(usr);
	}
	
	public void disable(User user) {
		disable(user.getId());
	}
	
	public void disable(UUID id) {
		User usr = get(id);
		
		usr.setEnabled(false);
		
		save(usr);
	}
	
	public void disable(String username) {
		User usr = get(username);
		
		usr.setEnabled(false);
		
		save(usr);
	}
	
	public void lock(User user) {
		lock(user.getId());
	}
	
	public void lock(UUID id) {
		User usr = get(id);
		
		usr.setAccountNonLocked(false);
		
		save(usr);
	}
	
	public void lock(String username) {
		User usr = get(username);
		
		usr.setAccountNonLocked(false);
		
		save(usr);
	}
	
	public void unlock(User user) {
		unlock(user.getId());
	}
	
	public void unlock(UUID id) {
		User usr = get(id);
		
		usr.setAccountNonLocked(true);
		
		save(usr);
	}
	
	public void unlock(String username) {
		User usr = get(username);
		
		usr.setAccountNonLocked(true);
		
		save(usr);
	}
	
	public void remove(User user) {
		repository.delete(user);
	}
	
	public void remove(UUID id) {
		repository.deleteById(id);
	}
	
	public void remove(String username) {
		repository.deleteByUsername(username);
	}
	
	public void update(User user) {
		if (repository.existsById(user.getId())) return;
		
		repository.save(user);
	}
	
	public User save(User user) {
		return repository.save(user);
	}
	
	public User register(RegisterRequest request) {
		if (repository.existsByUsername(request.getUsername())) throw new RuntimeException();
		
			DefailtUserBuilder builder = new DefailtUserBuilder();
		
		User user = builder.id(UUID.randomUUID())
				.username(request.getUsername())
				.password(passwordEncoder.encode(request.getPassword()))
				.build();
	
		return save(user);
	}
	
	public boolean isUserExist(UUID uuid) {
		return repository.existsById(uuid);
	}
	
	public boolean isUserExist(String username) {
		return repository.existsByUsername(username);
	}
}
