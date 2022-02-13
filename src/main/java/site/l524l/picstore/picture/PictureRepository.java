package site.l524l.picstore.picture;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import site.l524l.picstore.category.Category;

@Repository
public interface PictureRepository extends JpaRepository<Picture, UUID> {
	
	public List<Picture> findPictureByCategory(Category category);
	
	@Query(value = "SELECT * FROM picture p WHERE p.category_name = :category", nativeQuery = true)
	public List<Picture> findPictureByCategory(@Param("category")  String category);
	
}
