package site.l524l.picstore.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class RoleAuthority implements GrantedAuthority {
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String authority;
	
	private static final long serialVersionUID = -4265281935695614473L;
	
	
	public RoleAuthority() {
		
	}
	
	public RoleAuthority(String authority) {
		this.authority = authority;
	}
	
	
	@Override
	public String getAuthority() {
		return authority;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof RoleAuthority) {
			RoleAuthority role = (RoleAuthority) obj;
			
			if(authority.equals(role.authority)) return true;
			
		}
		
		return false;
	}
}
