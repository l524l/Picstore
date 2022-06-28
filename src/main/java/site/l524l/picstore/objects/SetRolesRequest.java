package site.l524l.picstore.objects;

import java.util.Set;

public class SetRolesRequest {
	
	private String username;
	private Set<String> roles;
	
	
	public SetRolesRequest() {
	}

	public SetRolesRequest(String username, Set<String> roles) {
		this.username = username;
		this.roles = roles;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
