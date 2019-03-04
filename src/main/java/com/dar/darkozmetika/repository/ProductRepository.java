package com.dar.darkozmetika.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dar.darkozmetika.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {

	@Query(value = "SELECT\r\n" + "  PC.*\r\n" + "FROM category AS C\r\n" + "INNER JOIN Product_Category AS PC\r\n"
			+ "  ON PC.category_id = C.id\r\n" + "WHERE (C.id=:id) AND (PC.category_id=:id)", nativeQuery = true)
	List<ProductModel> getAllProductForSpecificCategory(@Param("id") long id);

	@Transactional
	@Modifying
	@Query(value = "insert into Product_Category (product_id, category_id , description ,  image, price , name)  values (:product_id, :category_id, :description, :image, :price, :name)", nativeQuery = true)
	void insertProduct(@Param("product_id") Long product_id, @Param("category_id") long category_id,
			@Param("description") String description, @Param("image") String image, @Param("name") String name,
			@Param("price") int prices);

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Product_Category WHERE product_id=:product_id\r\n", nativeQuery = true)
	void deleteProduct(@Param("product_id") long id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE Product_Category\r\n"
			+ "SET description = :description, image= :image, price=:price, name=:category_name\r\n"
			+ "WHERE product_id = :id", nativeQuery = true)
	void updateProduct(@Param("id") long id, @Param("category_name") String category_name,

			@Param("description") String description, @Param("image") String image, @Param("price") int price);

}
