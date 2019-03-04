package com.dar.darkozmetika.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dar.darkozmetika.models.CategoryModel;
import com.dar.darkozmetika.models.ProductModel;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
	/*
	 * @Transactional
	 * 
	 * @Modifying
	 * 
	 * @Query(value = "SELECT * FROM Category WHERE id=:id", nativeQuery = true)
	 * CategoryModel finCategorydById(@Param("id") int id);
	 */

	@Transactional
	@Modifying
	@Query(value = "UPDATE Category\r\n"
			+ "SET category_name = :category_name, category_description= :category_description ,image_path = :image_path\r\n"
			+ "WHERE id = :id", nativeQuery = true)
	void updateCategory(@Param("id") long id, @Param("category_name") String category_name,

			@Param("category_description") String category_description, @Param("image_path") String image_path);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Category WHERE id=:id  \r\n", nativeQuery = true)
	void deleteCategory(@Param("id") long id);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Category WHERE id=:id", nativeQuery = true)
	void deleteProductByCategory(@Param("id") long id);

	
	@Query(value = "SELECT category_name FROM Category  WHERE id=:id", nativeQuery = true)
	String findName(@Param("id") long id);
}
