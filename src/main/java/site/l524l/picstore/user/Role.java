package site.l524l.picstore.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Role {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;

	private String name;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	private List<RoleAuthority> authorities;
	
	
	public Role() {
		
	}
	
	public Role(String name) {
		this.name = name;
		this.authorities = new ArrayList<RoleAuthority>();
		this.authorities.add(new RoleAuthority(name));
	}
	
	
	public void addAuthority(RoleAuthority authority) {
		if (authorities.contains(authority) == false) {
			authorities.add(authority);
		}
	}
	
	public void removeAuthority(RoleAuthority authority) {
		if (authorities.contains(authority) == true) {
			authorities.remove(authority);
		}
	}
	
	public String getName() {
		return name;
	}
	
	public List<RoleAuthority> getAuthorities() {
		return authorities;
	}
}
