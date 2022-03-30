package site.l524l.picstore.category;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Category {
	@Id
	private String name;
	
	private boolean isNsfw;
	
	
	public Category() {
	
	}

	public Category(String name, boolean isNsfw) {
		super();
		this.name = name;
		this.isNsfw = isNsfw;
	}

	
	public boolean isNsfw() {
		return isNsfw;
	}

	public void setNsfw(boolean isNsfw) {
		this.isNsfw = isNsfw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
