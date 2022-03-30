package site.l524l.picstore.picture;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import site.l524l.picstore.category.Category;
import site.l524l.picstore.media.Media;

@Entity
public class Picture implements Media {
	@Id
	private UUID id;
	
	private String path;
	
	private String extension;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Category category;
	
	
	
	@Override
	public void setId(UUID id) {
		this.id = id;
		
	}
	
	@Override
	public UUID getId() {
		return this.id;
	}
	
	@Override
	public void setPath(String path) {
		this.path = path;
		
	}
	
	@Override
	public String getPath() {
		return this.path;
	}
	
	@Override
	public void setExtension(String extension) {
		this.extension = extension;
		
	}
	
	@Override
	public String getExtantion() {
		return this.extension;
	}
	
	@Override
	public void setCategory(Category category) {
		this.category = category;
	}
	
	@Override
	public Category getCategory() {
		return this.category;
	}
}
