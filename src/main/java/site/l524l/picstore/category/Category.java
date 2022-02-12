package site.l524l.picstore.category;

import javax.persistence.Entity;

@Entity
public class Category {
	private String name;
	private boolean isNsfw;

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
