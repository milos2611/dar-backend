package com.dar.darkozmetika.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dar.darkozmetika.models.ProductModel;
import com.dar.darkozmetika.repository.ProductRepository;

@RestController
@RequestMapping("api/product")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;

	@GetMapping()
	private List<ProductModel> getProduct() {

		return this.productRepository.findAll();
	}

	@GetMapping("getAllProductForCategory/{id}")
	public List<ProductModel> getSpecificCategory(@PathVariable("id") long id) {
		return productRepository.getAllProductForSpecificCategory(id);
	}

	@PostMapping("/createCategory")
	@ResponseStatus(HttpStatus.OK)
	public void createCategory(@RequestBody ProductModel product) {
		productRepository.insertProduct(product.getProduct_id(), product.getCategory().getId(),
				product.getDescription(), product.getImage(), product.getName(), product.getPrice());

	}

	@PutMapping("/updateProduct/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void updateCategory(@PathVariable("id") long id, @RequestBody ProductModel product) {
		System.out.println(product.getDescription());
		this.productRepository.updateProduct(id, product.getName(), product.getDescription(), product.getImage(),
				product.getPrice());

	}

	@DeleteMapping("/deleteCategory/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCategory(@PathVariable("id") long id) {
		productRepository.deleteProduct(id);

	}

}
