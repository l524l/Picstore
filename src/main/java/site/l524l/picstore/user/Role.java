package site.l524l.picstore.user;

import java.util.Objects;

import javax.persistence.Embeddable;

import org.springframework.security.core.GrantedAuthority;

@Embeddable
public class Role implements GrantedAuthority {

	private String name;
	
	private static final long serialVersionUID = -6029655170812256612L;
	
	
	public Role() {
		
	}
	
	public Role(String name) {
		this.name = name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String getAuthority() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return Objects.equals(name, other.name);
	}
}
