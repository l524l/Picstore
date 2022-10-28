package site.l524l.picstore.picture;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import site.l524l.picstore.category.Category;

@Repository
public interface PictureRepository extends JpaRepository<Picture, UUID> {
	
	public List<Picture> findPictureByCategory(Category category);
	
	public int countByCategory(Category category);
	
	@Query(value = "SELECT COUNT(*) FROM api.picture WHERE category_name = :category", nativeQuery = true)
	public int countByCategory(@Param("category") String category);
	
	public List<Picture> findPictureByCategory(Category category, Pageable padgable);
	
	@Query(value = "SELECT * FROM api.picture p WHERE p.category_name = :category", nativeQuery = true)
	public List<Picture> findPictureByCategory(@Param("category")  String category);
	
	@Query(value = "SELECT * FROM api.picture p WHERE p.category_name = :category", nativeQuery = true)
	public List<Picture> findPictureByCategory(@Param("category")  String category, Pageable padgable);
	
}
